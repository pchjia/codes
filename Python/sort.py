#!/bin/env python

A = [2, 4, 9, 10, 1 ,6]

for i in range(len(A)):
    for j in range(i, len(A)):
        if A[i] > A[j]:
            tmp = A[j]
            A[j] = A[i]
            A[i] = tmp
for a in A:
    print(a)
