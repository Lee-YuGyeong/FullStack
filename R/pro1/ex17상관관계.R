# 상관분석
result <- read.csv("testdata/drinking_water.csv",fileEncoding = 'utf-8')
head(result)
summary(result)

cov(result$친밀도, result$적절성) # 공분산
cov(result)

?cor
cor(result$친밀도,result$적절성) # 상관 계수
cor(result)
cor(result, method = "pearson")

plot(result$적절성, result$만족도)

symnum(cor(result)) # 상관관계를 심볼로 표시
# 친 적 만
# 친밀도 1       
# 적절성 .  1    
# 만족도 .  ,  1 
# attr(,"legend")
# [1] 0 ‘ ’ 0.3 ‘.’ 0.6 ‘,’ 0.8 ‘+’ 0.9 ‘*’ 0.95 ‘B’ 1

install.packages("corrgram")
library(corrgram)
corrgram(result) # 상관관계를 색상으로 표시
corrgram(result, upper.panel = panel.conf) # 상관 계수 표시
corrgram(result, lower.panel = panel.conf) # 상관 계수 표시

install.packages("PerformanceAnalytics")
library(PerformanceAnalytics)
chart.Correlation(result, histogram = ,pch="+")

head(iris, 3)
cor(iris[,1:4], method = "pearson")
cor(iris[,1:4], method = "spearman")
cor(iris[,1:4])
symnum(cor(iris[,1:4]))
corrgram(cor(iris[,1:4]), upper.panel = panel.conf)

# 상관 계수 검정
cor.test(iris$Sepal.Length, iris$Petal.Length)
cor.test(iris$Sepal.Length, iris$Sepal.Width) # 약함 -> p-value값이 0.05보다 큼


