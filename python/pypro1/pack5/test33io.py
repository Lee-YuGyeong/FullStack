# 파일 입출력
import os

print(os.getcwd())

try:
    print('파일 읽기---')
    #f1=open(os.getcwd()+'\\ftest.txt', mode='r', encoding='utf-8')
    #f1=open(os.getcwd()+r'\ftest.txt', mode='r', encoding='utf-8')
    #f1=open(r'c:\mywork\pysou\pypro1\pack5\ftest.txt', mode='r', encoding='utf-8')
    f1=open('ftest.txt', mode='r', encoding='utf-8')
    print(f1)
    print(f1.read())
    f1.close
    
    print('\n파일 저장---')
    f2=open('ftest2.txt', mode='w', encoding='utf-8')
    f2.write('My Friends\n')
    f2.write('홍길동, tom')
    f2.close
    print('저장 성공')
    
    print('\n파일 추가---')
    f3=open('ftest2.txt', mode='a', encoding='utf-8')
    f3.write('\n손오공')
    f3.write('\n저팔계')
    f3.write('\n사오정')
    f3.close()
    print('추가 성공')
    
    print('파일 읽기===')
    f4=open('ftest2.txt', mode='r', encoding='utf-8')
    print(f4.readline())
    print(f4.readline())
    f4.close()
    
    print('파일 읽기===')
    f5=open('ftest2.txt', mode='r', encoding='utf-8')
    imsi=f5.readlines()
    print(imsi)
    f5.close()
    
except Exception as e:
    print('파일 처리 오류 :',e)






























