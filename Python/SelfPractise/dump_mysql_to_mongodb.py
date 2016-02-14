#!/bin/env python3

import mysql.connector
from pymongo import MongoClient


def main():
    try:
        con = mysql.connector.connect(user='pchjia', password='jia9692', database='test')
        cur = con.cursor();

        sql = "select * from goods;"
        cur.execute(sql)
        data = cur.fetchall()

        cur.execute("desc goods;")
        goods = cur.fetchall()
        columns = [i[0] for i in goods]

        res = "["
        for i in range(len(data)):
            res += '{'
            for j in range(len(columns)):
                res += "'" + columns[j] + "':"
                if type(data[i][j]) == str:
                    res += "'" + data[i][j] + "'"
                else:
                    res += str(data[i][j])
                if j < len(columns) - 1:
                    res += ','
            res += '}'
            if i < len(data) - 1:
                res += ',\t'
        res += "]"
        f = open('goods.txt', 'w')
        f.write(res)
        f.close()

        client = MongoClient()
        db = client.shop
        db.goods.drop()

        f = open('goods.txt', 'r')
        data = f.readlines()
        for elem in eval(data[0]):
            print(elem)
            db.goods.insert_one(elem)
        client.close()

    except:
        print('connection failed')

    finally:
        if not con:
            cur.close()
            con.close()

if __name__ == '__main__':
    main()
