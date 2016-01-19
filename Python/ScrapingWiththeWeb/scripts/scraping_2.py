from urllib.request import urlopen
from bs4 import BeautifulSoup

html = urlopen("https://www.pchjia.com/index.html")
bs_obj = BeautifulSoup(html)
title_list = bs_obj.findAll("a", {"class":"post-title-link"})
for title in title_list:
    print(title)
