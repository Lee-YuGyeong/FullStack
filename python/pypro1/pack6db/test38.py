# 키보드로 부서번호를 입력해 해당 부서의 직원자료(사번, 이름, 부서번호, 직급) 출력

import MySQLdb
import pickle

try:
    with open('mymaria.dat','rb') as obj:
        config = pickle.load(obj)
       

except Exception as e:
    print('err : ',e)

def chulbal():
    try:
        conn = MySQLdb.connect(**config)
        cursor = conn.cursor()
        
        buser_no = input('부서번호 입력 : ')
        #buser_no = 10
        sql = """
            select jikwon_no,jikwon_name,buser_num,jikwon_jik
            from jikwon
            where buser_num = {0}
        """.format(buser_no)
        #print(sql)
        cursor.execute(sql)
        datas = cursor.fetchall()
        #print(datas,len(datas))
        
        if len(datas) == 0:
            print(buser_no + '번 부서는 존재하지 않습니다.')
            return
        
        for no,name,num,jik in datas:
            print(no,name,num,jik)
        
        print('인원수 : '+str(len(datas)))
        
    except Exception as err2:
        print('process err : ',err2)
    
    finally:
        cursor.close()
        conn.close()
        

if __name__ == '__main__':
    chulbal()
    
