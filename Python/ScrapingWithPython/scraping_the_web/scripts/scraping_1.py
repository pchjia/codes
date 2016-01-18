from urllib.request import urlopen
from bs4 import BeautifulSoup
from urllib.error import HTTPError
from urllib.error import URLError
from socket import gaierror

def getTitle(url):
    try:
        html = urlopen(url)
    except HTTPError:
        return None
    except gaierror:
        return None
    except URLError:
        return None

    try:
        bsObj = BeautifulSoup(html.read())
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
