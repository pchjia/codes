#!/usr/bin/env python
# -*- coding: utf-8 -*-

# import os
# import sys
import json

import scipy as sp
from sklearn.feature_extraction.text import TfidfVectorizer
import nltk.stem
import sklearn.datasets


english_stemmer = nltk.stem.SnowballStemmer('english')

class StemmedTfidfVectorizer(TfidfVectorizer):
    def build_analyzer(self):
        analyzer = super(StemmedTfidfVectorizer, self).build_analyzer()
        return lambda doc: (english_stemmer.stem(w) for w in analyzer(doc))

data = sklearn.datasets.load_mlcomp('20news-18828', mlcomp_root='./data')
vectorizer = StemmedTfidfVectorizer(min_df=1, stop_words='english', decode_error='ignore')

groups = ['comp.graphics', 'comp.os.ms-windows.misc', 'comp.sys', 'ibm.pc.hardware', \
          'comp.sys.mac.hardware', 'comp.windows.x', 'sci.space']
train_data = sklearn.datasets.load_mlcomp('20news-18828', 'train', mlcomp_root='./data', categories=groups)
test_data = sklearn.datasets.load_mlcomp('20news-18828', 'test', mlcomp_root='./data', categories=groups)
train = vectorizer.fit_transform(train_data.data)
test = vectorizer.transform(test_data.data)
num_samples, num_features = train.shape
num_clusters = 6

from sklearn.cluster import KMeans
km = KMeans(n_clusters=num_clusters, init='random', n_init=1, verbose=1)
km.fit(train)
print km.labels_
print km.labels_.shape
res = km.predict(test)

s = []
for j in range(len(res)):
    similai_indices = (km.labels_ == res[j]).nonzero()[0]
    similar = []
    for i in similai_indices:
        dist = sp.linalg.norm((test[j] - train[i]).toarray())
        similar.append((dist, str(train_data.data[i])))
    similar = sorted(similar)
    s.append((str(test[j]), similar))
f = open('res.json', 'w')
json.dump(s, f)
f.close()
print s[0]

'''
path = './1400OS_Code/1400OS_03_Codes/data/toy/'
posts = [open(os.path.join(path, f)).read() for f in os.listdir(path)]

X_train = vectorizer.fit_transform(posts)
num_samples, num_features = X_train.shape
new_post = 'imagining databases'
new_post_vec = vectorizer.transform([new_post])
print X_train.shape
print vectorizer.get_feature_names()

def dist_raw(v1, v2):
    v1_norm = v1 / sp.linalg.norm(v1.toarray())
    v2_norm = v2 / sp.linalg.norm(v2.toarray())
    delta = v1_norm - v2_norm
    return sp.linalg.norm(delta.toarray())

best_doc = None
best_dist = sys.maxint
best_i = None
for i in range(0, num_samples):
    post = posts[i]

    if post == new_post:
        continue
    post_vec = X_train.getrow(i)
    d = dist_raw(post_vec, new_post_vec)
    print '*'*10 + '\n' + '\t%i with dist=%.2f: %s\n' % (i, d, post)
    if d < best_dist:
        best_dist = d
        best_i = i
print 'Best post is %i with dist=%.2f' % (best_i, best_dist)
'''
