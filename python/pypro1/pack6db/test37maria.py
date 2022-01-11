# 원격 데이터베이스 서버(MariaDB)와 연동

import MySQLdb
'''
conn=MySQLdb.connect(
    host='127.0.0.1',
    user='root',
    password='123',
    database='test',
    port=3306,
    charset='utf8',
    use_unicode=True)
'''
'''
config={
    'host':'127.0.0.1',
    'user':'root',
    'password':'123',
    'database':'test',
    'port':3306,
    'charset':'utf8',
    'use_unicode':True
    }
'''

#print(conn)
#conn.close()
import pickle
with open('mymaria.dat', mode='rb') as obj:
    config=pickle.load(obj)

try:
    conn=MySQLdb.connect(**config)
    cur=conn.cursor()
    
    # 자료 추가
    """
    sql = "insert into sangdata values(%s,%s,%s,%s)"
    sql_data = ('10','신상품1',5,1000)
    #cou = cur.execute(sql,sql_data) #성공하면 1, 실패하면 0
    cur.execute(sql,sql_data)
    conn.commit()   # 현재 컴퓨터에서 추가한 결과가 DB에 반영
    """
    # 자료 수정
    """
    sql = "update sangdata set sang=%s,su=%s,dan=%s where code=%s"
    sql_data = '핸드크림','10','8000','10'
    cur.execute(sql,sql_data)
    conn.commit()
    """
    
    #자료 삭제
    """
    code = '10'
    # sql = "delete from sangdata where code="+code # 비권장:secure coding 위배
    # sql = "delete from sangdata where code='{0}'".format(code) #권장 1
    sql = "delete from sangdata where code=%s" #권장2
    cou = cur.execute(sql,(code,))
    conn.commit()
    
    if cou > 0:
        print('삭제 성공')
    else:
        print('삭제 실패')
    """
    
    """
    a = 1
    print(type(a)) # 인티저
    a = (1)
    print(type(a)) # 인티저
    a = (1,)
    print(type(a)) # 튜플
    """
    
    #자료 읽기1
    sql="select * from sangdata"
    cur.execute(sql)
    
    for data in cur.fetchall(): #전체 자료 읽기
       #print(data) 
       print('%s %s %s %s'%data)
    
    print()
    #자료 읽기2
    for rec in cur:
        #print(rec)
        print(rec[0],rec[1],rec[2],rec[3])
    
    print()
    #자료 읽기3
    for (code, sang, su, dan) in cur:   #칼럼의 이름 아니고 그냥 변수의 이름
        print(code, sang, su, dan)
    
except Exception as e:
    print('오류 :',e)
    conn.rollback()
finally:
    cur.close()
    conn.close()
































