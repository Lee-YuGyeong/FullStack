# 관계형 데이터베이스와 연동한 프로그래밍
# 개인용 중에서 sqlite3 사용하기
# sqlite는 파이썬이 기본적으로 지원하므로 별도 설치 없이 그냥 사용할 수 있다.

import sqlite3

print(sqlite3.sqlite_version)

try:
    # db 연결 객체
    #conn=sqlite3.connect('example.db')  #현재 모듈과 같은 경로에 db 파일이 생성죔
    conn=sqlite3.connect(':memory:')  #주기억 장치에 db 파일이 생성죔. 실행이 끝나면 파일은 사라짐. 테스트용
    
    cur=conn.cursor()   #SQL문을 처리하는 객체
    
    #테이블 생성
    cur.execute("create table if not exists friend(code integer, name text, phone text)")
    
    #insert
    cur.execute("insert into friend (code, name, phone) values(1,'홍길동','111-1111')")
    cur.execute("insert into friend values(2,'지찬님','222-1111')")
    input_data = ('3', '오공', '333-3333')
    cur.execute("insert into friend values(?, ?, ?)", input_data)
    conn.commit()
    
    #select
    cur.execute("select * from friend")
    #print(cur.fetchone())
    print(cur.fetchall())
    
except Exception as e:
    print('err :',e)
    conn.rollback()
finally:
    cur.close()
    conn.close()


























