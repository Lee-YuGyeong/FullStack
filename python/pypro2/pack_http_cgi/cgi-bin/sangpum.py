# DB 자료를 읽어 웹으로 출력
import MySQLdb
import pickle

with open('mymaria.dat', mode='rb') as obj:
    config=pickle.load(obj)

print('Content-Type:text/html;charset=utf-8\n')
print('<html><body>')
print('상품정보<p/>')
print('<table border="1">')
print('<tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th></tr>')
try:
    conn = MySQLdb.connect(**config)
    cursor = conn.cursor()
    
    cursor.execute("select * from sangdata")
    datas = cursor.fetchall()
    
    for code, sang, su, dan in datas:
        print("""
        <tr>
            <td>{0}</td>
            <td>{1}</td>
            <td>{2}</td>
            <td>{3}</td>
        </tr>
        """.format(str(code),sang,su,dan))
    
except Exception as e:
    print('오류 : ',e)
finally:
    cursor.close()
    conn.close()
print('</table>')
print('</body></html>')