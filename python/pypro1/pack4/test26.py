# 메소드 오버라이딩(method overriding)
class Parent:
    def printData(self):
        pass

class Child1(Parent):
    def printData(self):
        print('Child1에서 부모 메소드 재정의')

class Child2(Parent):
    def printData(self):
        print('Child2에서 부모 메소드 재정의')
        print('부모 메소드와 이름은 같지만 기능은 다르다')

ch1=Child1()
ch1.printData()
print()
ch2=Child2()
ch2.printData()
print('\n------다형성---------------')
#par=Parent()
par=ch1
par.printData()
print()
par=ch2
par.printData()

print()
#plist=[]
#plist.append(ch1)
#plist.append(ch2)

plist=[ch1,ch2]
print(plist)

for aa in plist:
    aa.printData()

































 