va <- 1   # 변수의 값 할당
va <- 2
va = 3    # 주로 함수 내에서 = 사용
4 -> Va   # 대 소문자 구분분
cat(va,' ',Va)
print(va) # print는 하나씩
a<-10
b<-20
(c<-a+b) # print안쓰고 ()써도됨
a.b <- 3
print(a.b)

# 데이터 유형
kbs <- 9 # 숫자형 (numeric : double)
typeof(kbs)
kbs <- 9.5 # 숫자형 (numeric : double)
typeof(kbs)
mode(kbs)
class(kbs)

# 형 변환
mbc <- as.integer(kbs) #double을 integer로 형변환
mbc
typeof(mbc)
mbc <- 11L # 실수가 정수화
typeof(mbc)

ss <- "홍길동"
typeof(ss) # 문자형 (character)
mode(ss)

bb <- TRUE
typeof(bb) # 부울형(logical)
mode(bb)
cc <- 5.3 - 3i
typeof(cc) # 복소수형 (complex)
mode(cc)

# NA : 결측 데이터(값이 입력되지 않은 상태)
dd <- NA
typeof(dd) # (logical)
mode(dd)
is.na(dd) # 결측 데이터 확인

sum(2,3) # 합을 구하는 내장함수
sum(2,3,NA) # NA가 들어가면 연산불가
sum(2,3,NA, na.rm = TRUE) # na.rm = TRUE를 사용하여 NA를 없애고 연산

typeof(NULL) # 값으로 인식 X
length(NULL) # 0
sum(2,3,NULL)# NULL은 값으로 인식하지 않아서 계산 가능


typeof(NA) # 값으로 인식 O
length(NA) # 1
sum(2,3,NA) # NA는 값으로 인식하여 계산 불가


typeof(NaN) # 값으로 인식 O
length(NaN) # 1
sum(2,3,NaN) # NA는 값으로 인식하여 계산 불가

Inf # 무한대
0 / 0
Inf + - Inf # 양의 무한대 더하기 음의 무한대
0 * Inf

kbs <- c('second','first','third','first')
kbs
typeof(kbs)
summary(mbc)

mbc <- as.factor(kbs)
mbc
typeof(mbc)
summary(mbc)

f <- function(){
  return ('good')
}

f()
typeof(f) #closure

#--------------------
ls() # 모든 변수 확인
rm(bb) # bb 지우기
ls() 
rm(list=ls()) # 다 지우기
ls()
gc() #garbage collection으로 사용이 종료된 객체가 사용하고 있던 메모리를 작동적으로 해제하는 기법

#-- package(데이터 + 기능(함수) + 알고리즘 <== 얘네들의 묶음) --------------
# 라이브러리가 패키지 단위로 지원
available.packages() # 사용가능한 패키지들 보기
dim(available.packages()) # 18730    17

installed.packages() # 설치된 패키지들 보기
install.packages("plyr") #패키지 설치
library("plyr") # 라이브러리 로딩
search() # 현재 로딩된 패키지 확인
ls("package:plyr") # plyr 패키지가 제공하고 있는 내용
data(package="plyr") # plyr안에있는 데이터셋 제공
baseball

remove.packages("plyr") # 패키지 제거

# 도움말 2가지
# 인터넷은 mean in r 검색
help("mean")
?mean

x <- c(0:10, 50) #
xm <- mean(x)
c(xm, mean(x, trim = 0.10))

