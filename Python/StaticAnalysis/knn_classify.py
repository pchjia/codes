#!/usr/bin/env python
# -*- coding: utf-8 -*-

import scipy as sp


def distance(p0, p1):
    return sp.sum((p0-p1) ** 2)


def nn_classify(training_set, training_labels, new_example):
    dists = sp.array([distance(t, new_example) for t in training_set])
    nearest = dists.argmin()
    return training_labels[nearest]

data = sp.genfromtxt('seeds_dataset.txt')

features = data.copy()
features -= features.mean(axis=0)
features /= features.std(axis=0)

count = 0
length = len(features)
for i in range(length):
    a = sp.ones(length, bool)
    a[i] = False
    training_set = features[a, :-1]
    training_labels = data[a, -1]
    c = nn_classify(training_set, training_labels, features[i][:-1])
    if c != data[i][-1]:
        count += 1
        print c, data[i]

print count, length, float(length - count) / float(length)
