#커피 자판기 클래스 작성
#커피 자판기 본체는 돈을 계산하는 클래스를 포함관계로 불러다 사용
#카페 python 메뉴의 24번글 연습문제

class CoinIn:   #별도의 파일로 만들어도 됨(권장)
    coin=0      #고객이 입력한 금액
    change=0    #잔돈
    
    #생성자는 생략
    def calc(self, cupCount):
        result=""
        
        if self.coin < 200:
            result="요금이 부족합니다."
        elif cupCount*200>self.coin:
            result="요금이 부족합니다."
        else:
            self.change=self.coin-(200*cupCount)
            result="커피 "+str(cupCount)+"잔과 잔돈 "+str(self.change)
            
        return result
    
#커피 자판기 본체 클래스
class Machine:
    cupCount=1  #고객이 원하는 커피 잔 수
    
    def __init__(self):
        self.coinIn=CoinIn()    #클래스의 포함 관계
        
    def showData(self):
        self.coinIn.coin=int(input("동전을 입력하세요"))
        self.cupCount=int(input("몇 잔을 원하세요?"))
        print(self.coinIn.calc(self.cupCount))
        
if __name__ == '__main__':
    kangnam_machine=Machine()
    kangnam_machine.showData()

        