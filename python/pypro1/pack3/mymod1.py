#메인 모듈과 같은 경로에 사용자 정의 모듈을 작성, 스스로 실행하는 것이 목적이 아님. 호출당할 모듈
tot=123

def listHap(*ar):
    print(ar)
    if __name__=='__main__':    #응용 프로그램의 시작점
        print('여기가 최상위 모듈~~')
    
def kbs():
    print('대한민국 대표방송')
    
    
def mbc():
    print('문화방송은 11번')
    
