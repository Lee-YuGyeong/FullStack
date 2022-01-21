#선형 회귀
df <- data.frame(workhour=1:7, totalpay = seq(10000,70000, by=10000))
df

cor(df$workhour,df$totalpay)
plot(totalpay ~ workhour, data=df)

model <- lm(totalpay ~ workhour , data=df)
model # 절편과 기울기
# (Intercept)     workhour  
# -5.5e-12      1.0e+04  

#y = 1.0e+04 * x + -5.5e-12 # 모델이 잔차(에러, loss, cost, 손실)가 최소가 되는 일차방정식 생성

x = 1
1.0e+04 * x + -5.5e-12

x = 2.3
1.0e+04 * x + -5.5e-12

x = 7.7
1.0e+04 * x + -5.5e-12

