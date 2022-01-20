# 시각화 : 데이터에 따라 차트의 종류를 적당히 선택하는 것이 중요
# 이산형 데이터 : 막대, 점, 원형, 선 ... 그래프
# 연속형 데이터 : 상자박스, 히스토그램, 산점도 ... 그래프

stu <- read.csv("testdata/ex_studentlist.csv")
head(stu)
names(stu)

#막대
barplot(stu$grade)
barplot(stu$grade, ylim = c(0, 5), col=rainbow(7), main='제목')

barplot(stu$grade, horiz = T, xlab ='학년', ylab='학생', col=c(4,5,6)) # horiz - 가로 막대, col - 색

# zoom해서 크게, export해서 이미지 저장 가능

par(mfrow=c(1,2)) # 한 화면에 plot(그래프) 여러 개 출력
barplot(stu$grade)
barplot(stu$grade, horiz = T, xlab ='학년', ylab='학생', col=c(4,5,6), space = 1) # horiz - 가로 막대, col - 색

par(mfrow=c(1,1))

# 점
dotchart(stu$grade)
dotchart(stu$grade, color = 1:5, lcolor = 'black', cex=1.5,pch = 1:2)

# 원
df <- na.omit(stu) # 결측값이 있는 행은 제거
df
pie(df$age, labels = df$age, lty = 2) # lty - 라인 스타일
title('파이 차트')

# 연속형 데이터에서 효과적인 차트
boxplot(stu$height)
boxplot(stu$height, range=0)
boxplot(stu$height, range=1)
boxplot(stu$height, range=0, notch = T)
abline(h=170,lty=3,col="blue")

hist(stu$height, xlab = 'height', main='히스토그램',xlim=c(150,200), col='yellow')

hist(stu$height, breaks = 5, prob=T)
lines(density(stu$height))

# 산포도(산점도)
price <- runif(10,min = 1, max = 100)
price

plot(price, type = "l")
plot(price, type = "o")
plot(price, type = "h")
plot(price, type = "s")

par(mfrow=c(1,1))
head(iris)
pairs(iris[,1:4]) # 산점도 행렬 그래프
pairs(iris[iris$Species == 'setosa', 1:4])
pairs(~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width, data = iris, pch=c(1,2,3)[iris$Species])

# 차트를 그리는(설계하는) 방법 par(), layout()
# layout(mat, widths, heights) : 차트를 표현하는 영역을 grid형태로 분리
par(mar=c(1,1,1,1)) #여백

layout(matrix(c(1,0,2,3)))
#layout(matrix(c(1,0,2,3),2,2,byrow = T))
layout(matrix(c(2,0,1,3),2,2,byrow = T),c(2,1),c(2,1))
plot(iris$Sepal.Length)
hist(iris$Sepal.Width)
boxplot(iris$Sepal.Width)


par(mfrow=c(1,1))
par(mar=c(1,1,1,1))

install.packages("scatterplot3d")
library("scatterplot3d") 

# 붓꽃의 종류별 분류로 3차원 그래프 그리기
levels(iris$Species) 
iris

ir.setosa = iris[iris$Species=='setosa', ]
ir.virginica = iris[iris$Species=='virginica', ]
ir.versicolor = iris[iris$Species=='versicolor', ]

# 틀 생성 형식 : scatterplot3d( 밑변，우변칼럼명，좌변칼럼명，type) 
irdata <- scatterplot3d(iris$Petal.Length, iris$Sepal.Length, iris$Sepal.Width, type = 'n')

irdata$points3d(ir.setosa$Petal.Length, ir.setosa$Sepal.Length, ir.setosa$Sepal.Width, bg='red', pch=21)
irdata$points3d(ir.virginica$Petal.Length, ir.virginica$Sepal.Length, ir.virginica$Sepal.Width, bg='blue', pch=23)
irdata$points3d(ir.versicolor$Petal.Length, ir.versicolor$Sepal.Length, ir.versicolor$Sepal.Width, bg='yellow', pch=25)


# ggplot2 : plot() 함수를 확장한 라이브러리
library(ggplot2)
data(mpg)
head(mpg,n=3)
ggplot(data = mpg, aes(x = displ))
ggplot(data = mpg, aes(x = displ, y=hwy)) + geom_point()

ggplot(data = mpg, aes(x = displ, y=hwy)) + geom_point() + xlim(3,6) + ylim(10,30)

