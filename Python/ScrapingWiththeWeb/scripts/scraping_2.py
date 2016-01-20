from bs4 import BeautifulSoup

from model import openurl

html = openurl("https://www.pchjia.com/index.html")
bs_obj = BeautifulSoup(html)
title_list = bs_obj.findAll("a", {"class":"post-title-link"})
for title in title_list:
    print(title)
