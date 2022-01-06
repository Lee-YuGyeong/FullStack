#자동차의 부품 클래스인 핸들을 선언 : 자동 클래스와 별개로 작성
#PohamHandle 클래스는 스스로는 의미 없다. 다른 클래스에서 호출될 부품 클래스
class PohamHandle:
    quantity=0  #핸들의 회전량
    
    def LeftTurn(self, quantity):
        self.quantity=quantity
        return '좌회전'
    
    def RightTurn(self, quantity):
        self.quantity=quantity
        return '우회전'
