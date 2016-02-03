#!/bin/env python3
#coding: utf-8

import mysql.connector # MySQLdb for python2

def main():
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

if __name__ == "__main__":
    main()
