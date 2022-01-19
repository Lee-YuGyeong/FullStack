# **R에서 제공하는 자료구조 (Object type) **
# Vector, Matrix, Array, List, DataFrame
# 벡터가 가장 작은 데이터 타입

# Vector : 1차원 배열 형태의 자료구조 (동일한 형태의 자료만 저장됨)
# 벡터는 같은 자료형의 데이터를 정해진 갯수만큼 모아놓은 것이다. 

y <- 2022
y
y[0] # numeric(0)
y[1] # 2022 인덱스 1 부터 시작
y[2] # NA
is.vector(y) # TRUE
mode(y) # "numeric"
class(y)
typeof(y)
y <- as.integer(y)
class(y)
typeof(y)

seq(1,5) # 1부터 5까지 수열 생성, 1 2 3 4 5, 수열 생성 함수수
1:5 # 1 2 3 4 5
seq(1,10,2) # 1 3 5 7 9, 증가 값 2
seq(1,10,length.out = 4) # 1  4  7 10 ,전체 개수가 4개가 되도록 증가값 자동 결정

rep(1:3, 3) # 1 2 3 1 2 3 1 2 3, 123을 3번 반복
rep(1:3, each=3) #  1 1 1 2 2 2 3 3 3 , 1,2,3을 3번씩 반복
?rep # 도움말

v <- c(10,20,30,-5,-10, 'a',TRUE,F,T) # 데이터 타입이 같은 것으로 자동으로 맞춰짐, TRUE, FALSE는 T,F로 사용 가능
v # "10"    "20"    "30"    "-5"    "-10"   "a"     "TRUE"  "FALSE" "TRUE", 우선 순위 높은 것으로 변환
v <- c(10,20,30,-5,-10)
v #  10  20  30  -5 -10
v <- c(1,5,6:10,12)
v # 1  5  6  7  8  9 10 12
age <- c(10,20,30)
names(age) <- c("상인","정환","준") # 벡터의 칼럼명 지정 
age[1]
age["상인"]
age <- c(age,40)
age
age[10] <- 50 # 나머지는 결측값
age
age <- append(age, 60, after = 6) # 6번째 이후에 60 넣음
age
age <- NULL
age # age 전체 NULL, 변수는 살아있지만 값이 하나도 없음
rm(age) # 변수 삭제
age # age 찾을 수 없음

# 인덱싱, 슬라이싱
v <- c(13, -5, 20:23,12,-2:3)
v #  13 -5 20 21 22 23 12 -2 -1  0  1  2  3
v[1]
v[c(2,4,5)] #  -5 21 22
v[1:5] # 13 -5 20 21 22
v[-1] # 여집합(1번째만 빼고 모두) -5 20 21 22 23 12 -2 -1  0  1  2  3
v[-c(2,4,5)] #13 20 23 12 -2 -1  0  1  2  3
#v[1,2] #에러

a <- 1:10
a
a %% 3 # 나머지 연산자, 1 2 0 1 2 0 1 2 0 1
a+5 # 6  7  8  9 10 11 12 13 14 15
a^2 #  1   4   9  16  25  36  49  64  81 100
a**2 #  1   4   9  16  25  36  49  64  81 100
sqrt(a) # 1.000000 1.414214 1.732051 2.000000 2.236068 2.449490 2.645751 2.828427 3.000000 3.162278
sqrt(a)**2 # 1  2  3  4  5  6  7  8  9 10

a <- 1:4
b <- 4:6
a
b
# a + b # In a + b : longer object length is not a multiple of shorter object length

a <- 1:3
b <- 4:6
a
b
a + b # 5 7 9
a * b # 4 10 18
a[4] <- 2
a # 1 2 3 2
b
union(a,b) # 합집합(중복 X) 1 2 3 4 5 6
c(a,b) # 벡터 결합 (중복 O) 1 2 3 2 4 5 6
setdiff(a,b) # 차집합 1 2 3
b[4] <- 2
b # 4 5 6 2
intersect(a,b) # 교집합 2

# -------Matrix(행렬 구조, 2차원 배열)----------------
a <- 1:8
dim(a) # NULL

dim(a) <- c(2,4) # 2행 4열의 크기를 만들고 a 값을 열부터 채워나감
a 
#       [,1] [,2] [,3] [,4]
# [1,]    1    3    5    7
# [2,]    2    4    6    8
class(a) # "matrix" "array" 
typeof(a) # "integer"

m <- matrix(c(1:5))
m
#       [,1]
# [1,]    1
# [2,]    2
# [3,]    3
# [4,]    4
# [5,]    5
dim(m) # 5 1, 매트릭스의 차원 5행 1열
  

m <- matrix(1:9, nrow = 3) # 행의 개수 지정
m
#       [,1] [,2] [,3]
# [1,]    1    4    7
# [2,]    2    5    8
# [3,]    3    6    9
dim(m) #  3 3

m <- matrix(1:9, nrow = 3, byrow = T) # 행의 개수 지정하고 행 우선으로 자료를 채움
m
#       [,1] [,2] [,3]
# [1,]    1    2    3
# [2,]    4    5    6
# [3,]    7    8    9
dim(m) #  3 3

m
m[1] # 1
m[1,] # 1 2 3, 1행이 나옴
m[,1] # 1 4 7
m[, -1]
#       [,1] [,2]
# [1,]    2    3
# [2,]    5    6
# [3,]    8    9
m[-1, -1]
#       [,1] [,2]
# [1,]    5    6
# [2,]    8    9
m[1,c(1,3)] # 1 3

rownames(m) <- c('r1','r2','r3')
colnames(m) <- c('하나','둘','셋')
m
#     하나 둘 셋
# r1    1  2  3
# r2    4  5  6
# r3    7  8  9
m['r1',]
# 하나   둘   셋 
#   1    2    3 
dim(m) # 3 3
length(m) # 9
NROW(m) # 행의 개수 확인 3
nrow(m) # 소문자도 가능

# 연산
a <- matrix(c(1,2,3,4),nrow=2,ncol=2)
a
#       [,1] [,2]
# [1,]    1    3
# [2,]    2    4
b <- matrix(5:8 , 2, 2)
b
#       [,1] [,2]
# [1,]    5    7
# [2,]    6    8

a + b
#       [,1] [,2]
# [1,]    6   10
# [2,]    8   12

a - b
a / b
a * b
a %*% b # 행렬 곱셈

a
diag(a) # 대각 요소 값 추출
diag(3)

a
t(a) # 전치, 행렬전환

solve(a)
solve(solve(a))

# 행 또는 열 결합
x <- c(5,40,50:52)
x
y <- c(30,5,6:8)
y
mr <- rbind(x,y)
mr
cr <- cbind(x,y)
cr

# apply(변수, 행/열, 함수) : 함수를 실행하는 함수
?apply
x <- matrix(1:9,nrow=3)
x
#       [,1] [,2] [,3]
# [1,]    1    4    7
# [2,]    2    5    8
# [3,]    3    6    9
apply(x,1,max) # 행기준 가장 큰 값 7 8 9
apply(x,2,max) # 열기준 가장 큰 값 3 6 9

func <- function(x){
  x + c(1, 5, 10)
}
apply(x, 1, func)
#       [,1] [,2] [,3]
# [1,]    2    3    4
# [2,]    9   10   11
# [3,]   17   18   19

data()
?iris
dim(iris) # 150   5
head(iris,3) # 3행만 보기
tail(iris,3)
apply(iris[, 1:4],2, mean)
lapply(iris[,1:4], mean)
sapply(iris[,1:4], mean)

#Array : 다차원 배열
d <- c(1:12)
arr1 <- base::array(d) # base package에 array , base 생략 가능
arr1
dim(arr1) # 12
length(arr1) #12
is.array(arr1) #True

arr2 <- array(1:12, dim = c(6,2)) # 6행 2열 구조의 배열
arr2
dim(arr2)

arr3 <- array(1:12, dim = c(3,2,2)) # 3행 2열 2면 구조의 배열
arr3
dim(arr3)

arr3[,,1] # 1면만 추출
arr3[,1,1] # 1면 1열만 추출
arr3[1,,1] # 1면 1행만 추출
arr3[1,1,1] # 1면 1행 1열만 추출출

# List :서로 다른 타입의 데이터를 기억할 수 있다. 키, 값 형태의 테이터를 담는 연관배열
num <- list(c(1:5),c(6:10),c('a','b','c'))
num
# [[1]]
# [1] 1 2 3 4 5
# 
# [[2]]
# [1]  6  7  8  9 10
# 
# [[3]]
# [1] "a" "b" "c"

num[1] #  1 2 3 4 5
class(num[1]) # list

num[[1]] # [1]는 키
class(num[[1]]) # integer
num[[1]][2] # 2

num2 <- list(x = 1:5, y=6:10) # 키 값을 줌
num2
num2$x # 1 2 3 4 5

# 참고
a <- 1
tracemem(a) # 주소, <0000028E6A42F3E8>, a는 객체변수
untracemem(a)