#!/usr/bin/env python
# -*- coding: utf-8 -*-

import scipy as sp
import matplotlib.pyplot as plt


def error(f, x, y):
    return sp.sum((f(x) - y) ** 2)


data = sp.genfromtxt('web_traffic.tsv', delimiter='\t')
x = data[:, 0]
y = data[:, 1]
x = x[~sp.isnan(y)]
y = y[~sp.isnan(y)]

inflection = 3.5*7*24
xa = x[:inflection]
ya = y[:inflection]
xb = x[inflection:]
yb = y[inflection:]

fa = sp.poly1d(sp.polyfit(xa, ya, 1))
fb = sp.poly1d(sp.polyfit(xb, yb, 1))
fa_error = error(fa, xa, ya)
fb_error = error(fb, xb, yb)
print 'Error inflection=%f' %(fa_error + fb_error)

plt.scatter(x, y)
plt.title('Web traffic over the last month')
plt.xlabel('Time')
plt.ylabel('Hits/hour')
plt.xticks([w*7*24 for w in range(10)], ['week %i' %w for w in range(10)])
plt.autoscale(tight=True)
plt.grid()

fx = sp.linspace(0, x[-1], 1000)
plt.plot(xa, fa(xa), linewidth=4)
plt.plot(xb, fb(xb), linewidth=4)

'''
fp1, residuals, rank, sv, rcond = sp.polyfit(x, y, 1, full=True)
f1 = sp.poly1d(fp1)
fx = sp.linspace(0, x[-1], 1000)
print 'Error d=1', error(f1, x, y)

fp2 = sp.polyfit(x, y, 2)
f2 = sp.poly1d(fp2)
print 'Error d=2', error(f2, x, y)

fp3 = sp.polyfit(x, y, 3)
f3 = sp.poly1d(fp3)
print 'Error d=3', error(f3, x, y)
'''
# plt.plot(fx, f1(fx), linewidth=4)
# plt.plot(fx, f2(fx), linewidth=4)
# plt.plot(fx, f3(fx), linewidth=4)
# plt.legend(['d=%i' %f1.order, 'd=%i' %f2.order, 'd=%i' %f3.order], loc='upper left')


plt.show()


