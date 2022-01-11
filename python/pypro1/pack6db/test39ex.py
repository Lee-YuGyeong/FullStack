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
        
        n = input('a,m,f을 입력하세요 : ')
        
        if n=='a':
            sql = """
                select gogek_no,gogek_name,gogek_jumin from gogek 
            """
        elif n=='m':
            sql = """
                select gogek_no,gogek_name,gogek_jumin from gogek where gogek_jumin like '{0}' or gogek_jumin like '{1}' 
            """.format('%-1%','%-3%')
        elif n=='f':
            sql = """
                select gogek_no,gogek_name,gogek_jumin from gogek where gogek_jumin like '{0}' or gogek_jumin like '{1}' 
            """.format('%-2%','%-4%')
        else:
            print('a,m,f을 입력해주세요.')
            return
        cursor.execute(sql)
        datas = cursor.fetchall()
        
        if len(datas) == 0:
            print('존재하지 않습니다.')
            return
        
        for gogek_no,gogek_name,gogek_jumin in datas:
            print(gogek_no,gogek_name,gogek_jumin)
        
        print('인원수 : '+str(len(datas)))
        
    except Exception as e:
        print('processFunc err : ',e)
    finally:
        cursor.close()
        conn.close()

if __name__ == '__main__':
    processFunc()