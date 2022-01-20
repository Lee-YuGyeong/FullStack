# 연산자
no <- 7
no >= 2 + 2 * 2 | no < 5 %% 2
no >= 5 & no <= 10
no != 5

# 제어문
# if
x <- 10; y <- 5;
if (x + y >= 10 ){
  cat('결과는 ',x+y)
  cat('참일 때 수행')
}else{
  cat('거짓일 때 수행')
}

if (x >= 10){
  print('그렇다')
}else if(x>=5){
  print('5 이상')
}else{
  print('기타')
}

ifelse(x>5, 'good','bad')

# mpg dataset으로 if 연습
install.packages("ggplot2") # 시각화에 강력함
library(ggplot2)
head(mpg,3)
typeof(mpg)
is(mpg)
mpg <- as.data.frame(ggplot2::mpg)
head(mpg,3)
dim(mpg) # 234행 11열
str(mpg)
?mpg

mpg$total <- (mpg$cty + mpg$hwy) / 2
head(mpg,3)
mean(mpg$total) # total의 평균

if(mean(mpg$total) >= 20){
  cat("우수 연비")
}else{
  cat("일반 연비")
}

hist(mpg$total) # 도수분포표

mpg$test <- ifelse(mpg$total >= 20,'pass','fail')
head(mpg,3)
tail(mpg,3)
mpg
table(mpg$test)
qplot(mpg$test) # hist는 수치형만 됨

mpg$grade <- ifelse(mpg$total >= 30 ,'A',ifelse(mpg$total >= 20,'B','C'))
head(mpg)
mpg

# switch(비교 구문, 실행 구문1,...)
switch("age",id="hong",age=33,name="홍길동")
switch("name",id="hong",age=33,name="홍길동")

a <- 2 # 실행구문에 대한 순서
switch (a,mean(1:10), sd(1:10)) # a는 순서


# which
name <- c("kor","eng","mat","kor")
name
which(name=="kor")

no <- 10:13
df <- data.frame(번호=no, 이름=name)
df
which(df$번호 == 12)
which(df$이름 == "kor")

#반복문 - for, while, repeat -----------------------
i <- 1:10
for(n in i){
  print(n)
}

for(su in 1:9){
  res = 2*su
  cat(2,'*',su,'=',res,'\n')
}

#while
i <- 0
while (i<10){
  i = i+1
  print(i)
}

i<- 0
while(T){
  i = i+1
  print(i)
  if (i==5) break
}

#repeat : java의 do~while
cnt<-1
repeat{
  print(cnt)
  cnt=cnt+2
  if(cnt>10)break    #repeat블록 내에 탈출문 필요
}