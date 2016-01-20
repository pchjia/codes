from urllib.request import urlopen
from urllib.error import HTTPError
from urllib.error import URLError
from socket import gaierror

def openurl(url):
    try:
        html = urlopen(url)
    except HTTPError:
        return None
    except gaierror:
        return None
    except URLError:
        return None
    return html
