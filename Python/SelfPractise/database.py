#!/bin/e/env python
#coding: utf-8

import MySQLdb

def main():
    try:
        con = MySQLdb.connect(user="pchjia", password="jia9692", database="test")
        cur = con.cursor()

        cur.execute("select 3*4")

        data = cur.fetchone()

        for row in data:
            print(row)

    except MySQLdb.error:
        if con:
            con.rollback()
            print("SQL error")

    finally:
        if con:
            con.close()
