from urllib.request import urlopen
from bs4 import BeautifulSoup
import re

html = urlopen("https://www.pchjia.com/index.html")
bs_obj = BeautifulSoup(html, 'html.parser')
images = bs_obj.findAll("span", {"style":re.compile("background-image:url.*?")})
for image in images:
    print(image['style'])
