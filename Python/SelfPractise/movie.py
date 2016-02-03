#!/bin/env python3

import requests
import re

urls = ['http://www.dytt8.net', 'http://www.dygod.net',
        'http://www.dy2018.com', 'http://www.dytt.net']

def find_movies(url, fav):
    host = url.split(r"//")[1]
    headers = {'Host': host,
#            'Connection': 'keep-alive',
#            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
            'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36',
#            'Referer': 'https://www.google.com/',
#            'Accept-Encoding': 'gzip, deflate, sdch',
#            'Accept-Language': 'en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4'
            }

    s = requests.Session()
    r = s.get(url, headers=headers)
    r.encoding = 'gbk'

    pat = re.compile(r'<a(.*?)>(.*?)</a>')
    links = re.findall(pat, r.text)
    for link in links:
        for f in fav:
            if f in link[1]:
                url = re.findall(r'href=[\"|\'](.*?)[\"|\']', link[0])
                print(host + url[0] + "\t\t" + link[1])

#fav = [u'科幻', u'动作', u'动画', u'高分']
fav = [u'科幻']
for url in urls:
    print(url)
    find_movies(url, fav)
