#!/bin/env python
#coding: utf-8

import random

def montyHall(select, change):
    car = random.randint(1, 3)
    if car == select and change == 0:
        return 1
    if car == select and change == 1:
        return 0
    if car != select and change == 0:
        return 0
    if car != select and change == 1:
        return 1

if __name__ == "__main__":
    success = 0
    total = 10000
    for i in range(total):
        if montyHall(random.randint(1, 3), random.randint(0, 1)) == 1:
            success  += 1
    print(float(success)/float(total))
