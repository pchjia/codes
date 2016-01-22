from bs4 import BeautifulSoup

from model import openurl

def main():
    html = openurl("https://www.pchjia.com/index.html")
    bs_obj = BeautifulSoup(html)
    if html:
        title_list = bs_obj.find("div", {"class":"post-body"}).children
        for title in title_list:
            print();
            print(title)
    else:
        print("illegal url")

if __name__ == "__main__":
    main()
