# 직원 테이블의 사번, 이름을 입력받아 로그인에 성공하면 직원자료 보기(사번, 이름, 부서명, 연봉)
import MySQLdb
import pickle

try:
    with open('mymaria.dat','rb') as obj:
        config = pickle.load(obj)
except Exception as e:
    print('read err : ',e)
    
def processFunc():
    try:
        conn = MySQLdb.connect(**config)
        cursor = conn.cursor()
        
        jik_no = input('직원 번호 입력 : ')
        jik_name = input('직원 이름 입력 : ')
        
        sql = """
            select jikwon_no,jikwon_name,buser_name,jikwon_pay 
            from jikwon inner join buser on jikwon.buser_num=buser.buser_no
            where jikwon_no={0} and jikwon_name = '{1}' 
        """.format(jik_no,jik_name)
        #print(sql)
        
        cursor.execute(sql)
        datas = cursor.fetchall()
        
        if len(datas) == 0:
            print('입력된 자료에 해당되는 직원은 존재하지 않습니다.')
            return 
        
        for a,b,c,d in datas:
            print(a,b,c,d)
        
        
        
    except Exception as e:
        print('processFunc err : ',e)
    finally:
        cursor.close()
        conn.close()

if __name__ == '__main__':
    processFunc()
