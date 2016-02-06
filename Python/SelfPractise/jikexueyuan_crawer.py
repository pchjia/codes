#!/bin/env python3
#coding: utf-8

import requests
import re
import mysql.connector
from bs4 import BeautifulSoup


class Crawer:
    def __init__(self, start_url):
        self.start_url = start_url
        self.class_info = []
        self.now_url = self.start_url
        self.total = 86
        print("Starting crawing " + self.start_url)

    def crawing(self):
        while True:
            html = self.get_html()
            self.add_classes(html)
            if self.has_next_page():
                self.now_url = self.get_next_page()
            else:
                break

        return self.class_info

    def has_next_page(self):
        now = re.findall(r'pageNum=(\w+)', self.now_url)[0]
        if int(now) < self.total:
            return True
        else:
            return False

    def get_next_page(self):
        model = self.now_url.split("=")[0] + "="
        now = re.findall(r'pageNum=(\w+)', self.now_url)[0]
        now = int(now) + 1
        res = model + str(now)
        print("processing " + res + "...")
        return res

    def get_html(self):
        header = {"User-Agent": "Mozilla/5.0 (X11; Linux x86_64) \
            AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.97 Safari/537.36"}
        html = requests.get(self.now_url, headers=header).content
        return html

    def add_classes(self, html):
        soup = BeautifulSoup(html, 'lxml')
        lessons = soup.findAll("div", class_="lesson-infor")
        for lesson in lessons:
            classes = {}
            bs_obj = BeautifulSoup(str(lesson), 'lxml')
            classes['name'] = bs_obj.html.body.div.h2.text.strip()
            classes['desc'] = bs_obj.html.body.div.p.text.strip()
            time_level = bs_obj.findAll("dd")
            tmp = re.findall(r'em>([\s|\w]*?)</em>', str(time_level))
            classes['time'] = re.sub(r'\s+', ' ', tmp[0])
            classes['level'] = tmp[1].strip()
            learn_num = re.findall(r'>(.*?)</em', str(bs_obj.findAll(class_="learn-number")))[0]
            classes['learn_number'] = int(re.sub(u'人学习', '', learn_num))
            classes['url'] = bs_obj.a['href']
            self.class_info.append(classes)


def save_info(class_info):
    with open('classes.txt', 'w') as f:
        for classes in class_info:
            f.write(str(classes) + "\n")
    try:
        con = mysql.connector.connect(user="pchjia", password="jia9692", database="jikexueyuan")
        cur = con.cursor()
        for classes in class_info:
            name = classes['name']
            des = classes['desc']
            time = classes['time']
            level = classes['level']
            learn_number = classes['learn_number']
            url = classes['url']
            sql = 'insert into classes (name, des, time, level, learn_number, url) \
                  values("%s", "%s", "%s", "%s", %d, "%s");' % (name, des, time, level, learn_number, url)
            cur.execute(sql)
            con.commit()
    except:
        print('save info error')
        if con:
            con.rollback()
    finally:
        try:
            if con:
                cur.close()
                con.close()
        except:
            pass

if __name__ == "__main__":
    class_info = []
    start_url = "http://www.jikexueyuan.com/course/?pageNum=1"
    crawer = Crawer(start_url)

    class_info = crawer.crawing()
    save_info(class_info)
    for info in class_info:
        print(info)
