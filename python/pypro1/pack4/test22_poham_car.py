#클래스의 포함관계 연습
#완성 자동차를 위해 부품 클래스를 불러다 조립

#import pack4.test22poham_handle
from pack4.test22poham_handle import PohamHandle

print('자동차 만들기 : 여러 개의 부품으로 조립이 되는 데 여기서는 핸들만 부품으로 연습')

class PohamCar:
    turnshow='정지'   #핸들의 회전 방향을 알려주는 계기판
    
    def __init__(self,onwerName):
        self.onwerName=onwerName
        #self.handle=pack4.test22poham_handle.PohamHandle
        self.handle=PohamHandle()   #클래스의 포함관계
        
    def turnHandle(self, q):
        if q > 0:   #우회전으로 가정
            self.turnshow=self.handle.RightTurn(q)
        elif q<0:   #좌회전으로 가정
            self.turnshow=self.handle.LeftTurn(q)
        elif q==0:
            self.turnshow="직진"
            
if __name__ == '__main__':  #키워드임
    tom=PohamCar('미스터 톰')
    tom.turnHandle(10)
    print(tom.onwerName + "의 회전량은 "+tom.turnshow+str(tom.handle.quantity))
    tom.turnHandle(-5)
    print(tom.onwerName + "의 회전량은 "+tom.turnshow+str(tom.handle.quantity))
    print()
    sujan=PohamCar('미스 수잔')
    sujan.turnHandle(0)
    print(sujan.onwerName + "의 회전량은 "+sujan.turnshow+str(sujan.handle.quantity))
  

   

