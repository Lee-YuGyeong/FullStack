# 상속을 통한 다형성 구사하기

class ElecProduct:
    volume=0
    
    def volumeControl(self, volume):
        pass
    
class ElecTv(ElecProduct):
    def volumeControl(self,volume):
        self.volume=volume
        print('TV 소리 조절 후 크기는 ',self.volume)

class ElecRadio(ElecProduct):
    def volumeControl(self, volume):
        vol=volume
        self.volume+=vol
        print('Radio 소리 조절 후 크기는 ',self.volume)
        
    def showProduct(self):
        print('라디오 고유 메소드')

tv=ElecTv()
tv.volumeControl(5)
tv.volumeControl(2)
print()
radio=ElecRadio()
radio.volumeControl(3)
radio.volumeControl(2)
radio.volumeControl(-1)

print('다형성-----------------')
product=tv
product.volumeControl(7)
product=radio
product.volumeControl(7)
product.showProduct()































