from bs4 import BeautifulSoup

from module import openurl

def getTitle(url):
    html = openurl(url)
    try:
        bsObj = BeautifulSoup(html)
        title = bsObj.body.h1
    except AttributeError:
        return None
    return title

def main():
    title = getTitle("https://www.pchjia.com/index.html")
    if title == None:
        print("Title could not be found")
    else:
        print(title)

if __name__ == "__main__":
    main()
