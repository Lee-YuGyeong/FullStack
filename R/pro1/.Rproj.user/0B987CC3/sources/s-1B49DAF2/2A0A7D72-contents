# Data Frames : 구조화된 데이터 오브젝트다. 
# 데이터베이스의 테이블 구조와 유사, 칼럼 단위로 type이 달라도 됨
# 가장 많이 사용되는 객체 타입

# vector로 data.frame 객체 생성
no <- c(1,2,3)
name <- c("hong","lee","kim")
pay <- c(200,250,300)
df <- data.frame(no,name,pay)
df
#   no name pay
# 1  1 hong 200
# 2  2  lee 250
# 3  3  kim 300


df <- data.frame(bunho=no,irum=name,imkum=pay) # 칼럼명 주기
df
#   bunho irum imkum
# 1     1 hong   200
# 2     2  lee   250
# 3     3  kim   300


typeof(df) # "list"
class(df) #  "data.frame"
is(df) # "data.frame" "list"       "oldClass"   "vector"    

df <- data.frame(irum=c('james','oscar','tom'),nai=c(33,44,22)) # 행 번호는 자동으로 매겨짐
df
#    irum nai
# 1 james  33
# 2 oscar  44
# 3   tom  22

df <- data.frame(irum=c('james','oscar','tom'),nai=c(33,44,22), row.names = c("one","two","three"))
df
#        irum nai
# one   james  33
# two   oscar  44
# three   tom  22
nrow(df)
ncol(df)
str(df)
df$irum
df$nai

summary(df)
head(df,n=2)
tail(df,n=2)
names(df) # 열 이름 확인

# matrix로 data.frame 객체 생성
m<-matrix(c(1,"hong",150,2,'lee',250,3,'kim',300),3, by=T)
m
#       [,1] [,2]   [,3] 
# [1,] "1"  "hong" "150"
# [2,] "2"  "lee"  "250"
# [3,] "3"  "kim"  "300"
mdf <- data.frame(m)
mdf
#   X1   X2  X3
# 1  1 hong 150
# 2  2  lee 250
# 3  3  kim 300
class(mdf) # "data.frame"

m <- matrix(1:6, nrow = 3)
m
mdf <- data.frame(m)
mdf
colnames(mdf) <- c("c1","c2")
mdf

mdf$c1 # 반환값 벡터
mdf['c1'] # 반환값 리스트
mdf[,2] # 모든 행의 2번째 열만 추출
mdf[1,2]
mdf[1:2,1:2]

mdf[mdf$c1==2, ] # 조건 지정으로 원하는 행 출력, 칼럼값이 2인 것의 행이 출력
subset(mdf, c1 == 2) # 위와 결과 같음, 데이터 셋 중에서 일부만 얻을 수 있음

mdf[mdf$c1 == 2 & mdf$c2 == 5,] # &, | 사용
subset(mdf, c1 == 2 & c2 == 5)

mdf[mdf$c1 == 2, c(1,2)] # 조건과 열 지정
subset(mdf, c1 ==2, select=c(1,2))

mdf$c2 <- ifelse(mdf$c2 == 4, NA, mdf$c2)
mdf
summary(mdf)
mean(mdf$c2)
mean(mdf$c2, na.rm = T)

# data.frame에 행 또는 열 추가/삭제
mdfr <- rbind(mdf,c(10,11))
mdfr

mdfc <- cbind(mdf,c3 = c("a","b","c"), c3=c("a1","b1","c1"))
mdfc

mdfc[,"c1"] <- NULL
mdfc

mdfr <- mdfr[-1,]
mdfr

# data.frame 객체를 파일로 저장 후 읽기 : 속도가 빠름
df <- data.frame(eng=c(90,80,70), mat=c(100,66,88))
df
save(df, file = "dfobj.rda") # 저장
rm(df)
load(file = "dfobj.rda")
df

# 참고 : data.frame 을 개선한 package로 data.table
install.packages("data.table")
library(data.table)
dt <- as.data.table(df)
dt
#    eng mat
# 1:  90 100
# 2:  80  66
# 3:  70  88
# 번호에 : 이 있음 , 더 많은 기능 가짐

# merge : 두 개 이상의 data.frame을 병합
height <- data.frame(id=c(1,2,2),h=c(180,175,178))
weight <- data.frame(id=c(1,2,3),w=c(80,75,88))
height
weight

merge(height,weight) # inner join 과 비슷
merge(height,weight, by.x = "id") # id를 기준으로 병합 , 위와 같음
merge(height,weight, by.x = "id", by.y = "id")
df <- merge(height,weight,all=T) # outer join과 비슷

# 그룹연산 위해 package 설치
install.packages("dplyr")
library(dplyr) # filter
?dplyr
library(help="dplyr")
lsf.str("package:dplyr") # 해당 패키지가 제공하는 함수를 확인

df
summarise(group_by(df, h))



#--------------------------------------------------------
# <연습문제4> 다음의 벡터를 컬럼으로 데이터프레임을 생성하시오.

name <- c("가인수", "유관순", "이순신", "김유신", "홍길동")
age <- c(55, 45, 45, 53, 15) # 연령
gender <- c(1, 2, 1, 1, 1)    # 1:남자, 2: 여자
job <- c("연예인", "주부", "군인", "직장인", "학생")
sat <- c(3,4,2,5,5)        # 만족도
grade <- c("C","C","A","D","A")
total <- c(44.4,28.5,43.5,NA,27.1)   # 총구매금액(NA:결측치 해결)

# <조건1> 위 7개 벡터를 이용하여 user란 이름(변수명)으로 데이터 프레임 생성
user <- data.frame(name,age,gender,job,sat,grade,total)
user

# <조건2> 성별(gender) 변수를 이용하여 히스토그램 그리기 (hist)
hist(user$gender)
plot(user$sat) # 산점도

# <조건3> user에서 짝수행만 선택해서 user2(dataframe)를 만드시오.
user2 <- user[c(2,4),]
user2

user2 <- user[seq(2,4,2),]
user2

user2 <- user[seq(2,nrow(user),2),] # 제일 맞는 방법
user2 
#--------------------------------------------------------

# <연습문제5> 
  
r1 <- c(100, 80, 90)
r2 <- c(90, 80, 75)
r3 <- c(86, 78, 95)
da <-data.frame(r1, r2, r3)
da

#da를 대상으로 apply()를 적용하여 행/열 방향으로 내장 함수(max,mean())를 적용하시오.
#<조건1> 행/열 방향 max()함수 적용
apply(da,1,max)
apply(da,2,max)

#<조건2> 행/열 평균 mean()함수 적용
apply(da,1,mean)
apply(da,2,mean)
round(apply(da,2,mean),2)

#<연습문제6> kor(국어 점수 2개)과 eng(영어 점수 2개)를 id로 merge해서 score에 할당하시오.

kor <- data.frame(id=c(1,2), kor=c(85,75))
eng <- data.frame(id=c(1,2), eng=c(95,86))

kor
eng
score <- merge(kor,eng,by.x = "id",by.y = "id")
score

# aggregate() 집계함수
score <- rbind(score, c(1,80,70))
score <- rbind(score, c(2,80,70))
score
aggregate(kor ~ id, score, sum) # (계산될 칼럼 ~ 기준 칼럼, 데이터, 함수)
aggregate(kor ~ id, score, min)
