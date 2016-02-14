#!/bin/env python3
#coding: utf-8

import mysql.connector # MySQLdb for python2
import pymongo
from pymongo import MongoClient


def test_mysql():
    try:
        con = mysql.connector.connect(user="pchjia", password="jia9692", database="test")
        cur = con.cursor()

        cur.execute("select * from goods;")

        data = cur.fetchall()

        for row in data:
            print(row)

    except :
        print("error")
        if con:
            con.rollback()
            print("SQL error")

    finally:
        if con:
            con.close()

def test_mongo():
    try:
        client = MongoClient("mongodb://localhost:27019")
        db = client.shop
        cursor = db.goods.find({}, {'_id': 0})
        for doc in cursor:
            print(doc)
        client.close_cursor(id(cursor))
        client.close()
    except pymongo.errors.ServerSelectionTimeoutError as e:
        print("connection errors")
        print(e)
    except:
        print("unknown error")

if __name__ == "__main__":
    test_mysql()
    test_mongo()

