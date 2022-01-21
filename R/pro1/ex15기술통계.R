# 표본 추출
# 표본이란 연구대상 전체에서 선택된 일부를 말하며, 이런 표본을 선택하는 과정을 표본추출(표집)이라고 말한다. 표본추출에서는 표본이 모집단(전체집단)을 대표할 수 있는지의 여부인 대표성이 가장 중요하다. 표본이 모집단의 속성을 거의 갖고 있다면, 표본의 속성으로부터 도출한 어떤 결과는 모집단에도 그대로 적용할 수 있을 것이다. 이처럼 추출한 표본으로부터 도출할 결과를 통해 모집단의 속성을 추측하는 것을 모집단 추론(population inference)이라고 한다.

# 단순임의 추출 : 모집단으로부터 샘플을 균등하게 추출

sample(1:10,5) # 비복원 추출
sample(1:5,5,replace=T) #복원 추출 ( 고를때 원래 집단이 초기화)

# 층화 임의 추출 : 모집단이 계층을 가진 경우 각 계층 원소로부터 임의 추출 ( 성별, 연령대)
install.packages("sampling")
library(sampling)
str(iris) # 3 levels "setosa","versicolor" 3개의 레벨이 있다

strata('Species',size=c(3,3,3),method = 'srswor', data = iris) # 각 꽃의 종류별로 3개씩뽑음(size), 비복원 추출(srswor)

# 계통 추출 : 모집단의 임의 위치에서 매 K번째 항목을 표본으로 추출, 모집단이 어떤 특징을 갖고 있을 때, 단순임의 추출보다 계통추출이 더 좋다.
install.packages("doBy")
library(doBy)
(x <- data.frame(x=1:10))
sampleBy(~1, frac = .3, data = x, systematic = T) # 30%내에서 하나씩 뽑기

# 기술통계 : 평균, 분산, 표준편차. 중앙값, 사분위수, 첨도, 왜도, 도수분포표, 분할표 등으로 데이터를 표현
# 분할표
tal <- c('a','b','c','d')
table(tal)

x <- c('1','2','2','1')
y <- c('a','b','a','b')
n <- c(3,5,8,7)
df <- data.frame(x,y,n)
df

ta2 <- xtabs(formula = n~x+y, data = df) # x+y
ta2

# 연속형 척도 변수의 기술 통계량
data <- read.csv("testdata/descriptive.csv")
head(data)
summary(data)
str(data)

data <- na.omit(data) # NA가 있는 행 제거, 결측치가 있는 데이터 다 지우기
data
str(data)
summary(data$cost) # 이상치 확인
data <- subset(data,data$cost >= 2 & data$cost <= 10) # 이상치 제거
summary(data$cost)

length(data$cost)
plot(data$cost)
boxplot(data$cost)

# 왜도, 첨도
install.packages("moments")
library(moments)
cost <- data$cost
skewness(cost) # 왜도(skewness)는 분포의 비대칭성을 나타내는 척도, 음수면 데이터가 우측으로 치우침
# [1] -0.2402368
hist(cost,prob=T)
lines(density(cost))

kurtosis(cost) # 첨도는 확률분포의 꼬리가 두꺼운 정도를 나타내는 척도, 0보다 크므로 정규분포보다 뾰족함

head(data)
summary(data$resident) # 거주지역에 대한 리코딩
data$resident2[data$resident == 1] <- '서울특별시'
data$resident2[data$resident >= 2 & data$resident <= 4] <- '광역시'
data$resident2[data$resident == 5] <- '시구군'
data

x<- table(data$resident2)
x
prop.table(x) # 비율
round(prop.table(x) * 100, 1) # 백분율

head(data)
data$level2[data$level == 1] <- "고졸"
data$level2[data$level == 2] <- "대졸"
data$level2[data$level == 3] <- "대학원졸"
round(prop.table(table(data$level2)),2) # 비율 구하기

# ... 기술 통계 보고서 작성 ...

