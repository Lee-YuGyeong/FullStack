# 추론 통계 : 표본 집단 데이터로 표본 통계량을 구해 모집단의 모수를 추론

#상관계수(相關係數, correlation coefficient)는 두 변수 사이의 통계적 관계를 표현하기 위해 특정한 상관 관계의 정도를 수치적으로 나타낸 계수이다. 공분산을 표준화한 계수이다.
#여러 유형의 상관계수가 존재하지만 제각기 자신들만의 정의와 특징이 있다. 이들은 모두 값의 범위가 -1에서 +1 사이에 속하며 여기서 ±1은 정도가 가장 센 잠재적 일치를 나타내고 0은 정도가 가장 센 불일치를 나타낸다.
#두 변수 데이터의 밀도를 -1~1 사이로 표현

# 상관관계 분석
# DM 발송(x) : 1,2,3,4,5
# 제품 판매 개수 : 3,5,8,11,13
x <- c(1,2,3,4,5)
y <- c(3,5,8,11,13)
plot(x,y)
cov(x,y) # 공분산 6.5
cor(x,y) # 상관계수 0.9970545

cov(1:5,2:6)
plot(1:5,2:6)
cor(1:5,2:6)

cov(1:5,c(3,3,3,3,3))
plot(1:5,c(3,3,3,3,3))
cor(1:5,c(3,3,3,3,3))

cov(1:5,5:1)
plot(1:5,5:1)
cor(1:5,5:1)

#골턴의 아버지와 아들 키 데이터로 상관관계 확인
hf<-read.csv("testdata/galton.csv")
dim(hf)
head(hf)

hf_man<-subset(hf,sex=='M')
dim(hf_man)
head(hf_man)
hf_man<-hf_man[c('father','height')]
head(hf_man)

f_mean<-mean(hf_man$father)
s_mean<-mean(hf_man$height)
f_mean    #아버지 키 평균 : 69.16817
s_mean    #아들 키 평균 : 69.22882

# 공분산 계산을 수식으로 확인해 본 후 내장함수 결과 비교
cov_sum <- sum((hf_man$father - f_mean) * (hf_man$height - s_mean)) # 편차 곱의 합
cov_xy <- cov_sum / (nrow(hf_man) - 1)
cov_xy # 2.368441

# 내장함수
cov(hf_man$father, hf_man$height) # 2.368441, 계산한 것과 같음
# 관계의 방향은 보여주나 관계의 정도는 파악하기 어려움

# 상관계수 계산을 수식으로 확인해 본 후 내장함수 결과 비교
r_xy <- cov_xy / (sd(hf_man$father) * sd(hf_man$height))
r_xy # 0.3913174

cor(hf_man$father, hf_man$height, method = "pearson") # 0.3913174 연속형 데이터를 대상
# 상관계수 검정을 통해 변수 간의 관계(통계적 유의성)를 파악할 수 있다.

# 시각화
plot(height ~ father, data = hf_man, xlab="아버지 키",ylab="아들키") # 양의 상관관계, 밀도가 0.3913174정도, 데이터가 퍼진정도
abline(lm(height ~ father, data = hf_man),col="red",lwd=2)#추세선(회기선) 그리기, 추세선에는 평균값이 지나가는데 실제값과 평균값의 차이를 오차라고한다. (lwd = 선의 굵기)


