# 함수
# 내장함수
seq(0,5,by=1.5)

set.seed(123)
rnorm(10,mean = 0,sd=1) # 정규분포
hist(rnorm(100,mean = 1,sd = 1))

runif(10,min=0,max=100)
hist(runif(1000,min=0,max=100))

sample(0:100,10) # 샘플 얻기 0에서 100까지 10개

vec <- 1:10
min(vec)
mean(vec)
quantile(vec)
table(vec) # 빈도수
abs(-5)
factorial(5)
getwd()
# 함수를 많이 알고 있는 것이 R에서는 매우 중요

# 사용자 정의 함수
func1 <- function(){
  print("사용자 정의 함수")
}

func1()
func1()

func2 <- function(arg){
  print("매개변수 사용")
  print(arg+10)
}

func2(10)

gugu_func <- function(dan){
  for(d in dan){
    for(i in 1:9){
      cat(d,'*',i,'=',d*i,' ')
    }
    cat('\n')
  }
}
gugu_func(2:9)
