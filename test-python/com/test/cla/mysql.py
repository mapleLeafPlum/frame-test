import pymysql

if __name__ == '__main__':
    conn = pymysql.connect(host="192.168.1.12", user="uhome", password="uhome110", database="uhome", port=3306, charset="utf8")
    cursor = conn.cursor()
    cursor.execute("select * from u_inspection_task limit 2")
    results = cursor.fetchall()
    # cursor.fetchmany(2)
    # 获取查询的所有记录
    print("id", "name", "password")
    # 遍历结果
    for row in results:
        ids = row[0]
        name = row[1]
        password = row[2]
        print(row)

    # 查询数据的SQL语句
    sql = "select * from u_inspection_task ut where ut.inspection_task_id=10041;"
    # 执行SQL语句
    cursor.execute(sql)
    # 获取单条查询数据
    ret = cursor.fetchone()

    print("id", "name", "password")
    print(ret)

    cursor.close()
    conn.close()
