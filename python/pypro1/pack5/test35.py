# 키보드로 동을 입력해 해당 동의 자료를 파일에서 읽기
print('a',chr(9),'b')
try:
    dong=input('동 이름을 입력 : ')
    #print(dong)
    #dong='개포'
    
    with open(r'zipcode.txt', mode='r', encoding='euc-kr') as f:
        line=f.readline()   #한 행 읽기
        #print(line)
        
        while line: #읽은 행의 자료가 있으면 True, 없으면 False
            #lines=line.split('\t')  #tab을 기준으로 문자열 자르기
            lines=line.split(chr(9))
            #print(lines)
            
            if lines[3].startswith(dong):
                #print(lines)
                print('['+lines[0]+']'+lines[1]+' '+ \
                      lines[2]+' '+lines[3]+' '+lines[4])
                
            line=f.readline()   #새로운 행 읽기
    
except Exception as e:
    print('처리 오류 :',e)








































