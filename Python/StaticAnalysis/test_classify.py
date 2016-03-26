#!/usr/bin/env python
# -*- coding: utf-8 -*-

from matplotlib import pyplot as plt
from sklearn.datasets import load_iris
import numpy as np


data = load_iris()
features = data['data']
feature_names = data['feature_names']
target = data['target']
plt.figure(figsize=(16, 8))

is_setosa = (target == 0)
features = features[~is_setosa]
labels = np.array([data['target_names'][i] for i in target])
labels = labels[~is_setosa]
target = target[~is_setosa]
virginica = (labels == 'virginica')

best_acc = -1.0
for fi in xrange(features.shape[1]):
    thresh = features[:, fi].copy()
    thresh.sort()
    for t in thresh:
        pred = (features[:, fi] > t)
        acc = (pred == virginica).mean()
        if acc > best_acc:
            best_acc = acc
            best_fi = fi
            best_t = t

print best_acc, best_fi, best_t

def set_scatter(figure=1, targets=[0, 1], t=0, marker='>', c='r', repaint=False):
    plt.subplot(2, 3, figure)
    x = features[target==t, targets[0]]
    y = features[target==t, targets[1]]
    if not repaint and best_fi == targets[1]:
        plt.fill_between(x, y, where=(y>best_t), color='grey')
    plt.xlabel(feature_names[targets[0]])
    plt.ylabel(feature_names[targets[1]])
    plt.scatter(x, y, marker=marker, c=c)


for t, marker, c in zip(xrange(3), '>ox', 'rgb'):
    set_scatter(1, [0, 1], t, marker, c)
    set_scatter(2, [0, 2], t, marker, c)
    set_scatter(3, [0, 3], t, marker, c)
    set_scatter(4, [1, 2], t, marker, c)
    set_scatter(5, [1, 3], t, marker, c)
    set_scatter(6, [2, 3], t, marker, c)
for t, marker, c in zip(xrange(3), '>ox', 'rgb'):
    set_scatter(6, [2, 3], t, marker, c, True)

plt.show()
