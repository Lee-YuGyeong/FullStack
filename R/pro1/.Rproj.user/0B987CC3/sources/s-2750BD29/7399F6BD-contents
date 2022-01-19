# 데이터 입력
# 키보드 입력
# 1. scan()
n <- scan() # 숫자 입력
n
sum(1:n)

ss<-scan(what = "") # 문자열 입력
ss

# 2. 다량의 데이터를 표의 형태로 입력
df1 <- data.frame()
df1
df1 <- edit(df1)
df1

# 파일 읽기
# read.table() 함수
getwd() # 현재 경로 확인
list.dirs()
list.files()

stu <- read.table("testdata/student.txt")
stu
class(stu)
is(stu)

read.table("testdata/student1.txt", header = T) # 칼럼명이 있는 파일 읽기
read.table("testdata/student2.txt", header = T, sep=";") # 구분자가 공백이외의 값인 경우
read.table("testdata/student2.txt", header = T, sep=";",skip = 2) 
read.table("testdata/student3.txt", header = T, sep = " ", na.strings = "-") # 특정문자 NA 처리
read.table("testdata/student4.txt", header = T, sep=",")

#read.csv() 함수 (comma saperate value)
read.csv("testdata/student4.txt",na.strings = '-') # 기본값이 header = T

# excel 파일 읽기
install.packages("xlsx")
library(xlsx)
read.xlsx2(file = "testdata/student.xlsx", sheetIndex = 1)
#read.xlsx2(file.choose(),sheetIndex = 1) # 파일 선택 창 호출

# 데이터 출력 -------------------------------------------
a <- 10 ; b <- 20; c <- a*b
cat('a * b의 결과는',c) 
#print('a * b의 결과는',c)# print는 인자 2개 불가능
print(c)

# 파일로 저장
data <- read.csv("testdata/binary.csv")
data <- head(data,5)
data
#write.table(data,"output/out1.csv")
write.table(data,"output/out1.txt")
write.table(data,"output/out2.csv", row.names = FALSE) # 행이름 제외
write.table(data,"output/out3.csv", row.names = FALSE, quote = FALSE)

name <- c("관우","장비","유비")
age <- c(35, 23, 26)
mydf <- data.frame(name,age)
mydf
write.csv(mydf,"output/csv1.csv",fileEncoding = "UTF-8")
write.csv(mydf,"output/csv2.csv", fileEncoding = "UTF-8", row.names = FALSE)

library(xlsx)
write.xlsx(mydf,"output/exc.xlsx",row.names = FALSE)

