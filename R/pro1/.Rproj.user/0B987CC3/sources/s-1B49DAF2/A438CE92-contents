# 명목형(범주형) 변수로 도수분포표 작성
df <- read.csv("https://raw.githubusercontent.com/pykwon/Test-datas-for-R/master/ex_studentlist.csv")
df
summary(df) # 요약 통계
str(df) # 구조

# table() 함수로 분할표 : gender, bloodtype
table(df$gender, df$bloodtype)
#    A AB B O
# 남 1  2 3 2
# 여 2  1 1 3

freq <- table(df$bloodtype) 
freq
# A AB  B  O 
# 3  3  4  5 

rfreq <- prop.table(freq) # 상대도수, 결과가 비율로 출력, 전체 합 1
rfreq
#         A        AB         B         O 
# 0.2000000 0.2000000 0.2666667 0.3333333 

rtable <- rbind(freq, rfreq)
rtable

rtable <- addmargins(rtable, margin = 2) # sum 들어감, 행(2), 열(1) 합
rtable

# 연속형 (수치형) 변수로 도수분포표 작성 : height
head(df,3)

df$height # 구간(계급) 설정 - cut() 함수
factorHeight <- cut(df$height, breaks = 4)
factorHeight

freqHeight <- table(factorHeight)
freqHeight

freqHeight <- rbind(freqHeight, prop.table(freqHeight))

rownames(freqHeight)[1] <- '빈도수'
rownames(freqHeight)[2] <- '비율'
freqHeight

cumFreq = cumsum(freqHeight[2,]) # 누적합 연산
cumFreq
freqHeight <- rbind(freqHeight, cumFreq) # 누적 상대 도수 추가
freqHeight

freqHeight <- addmargins(freqHeight, margin = 2)
freqHeight
