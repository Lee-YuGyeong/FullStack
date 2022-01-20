# 한국복지패널 데이터(한국보건사회연구원에서 작성한 자료로, 2016년 6914 가구의 16664명에 대한 정보가 담겨있다.

install.packages("readxl")

library(foreign)
library(readxl)
library(ggplot2)
library(dplyr)

ori_welfare <- foreign::read.spss(file = "Koweps_hpc10_2015_beta1.sav", to.data.frame = T)
welfare <- ori_welfare
head(welfare)
View(welfare)
names(welfare)

welfare <- rename(welfare,
                  sex = h10_g3,
                  birth=h10_g4,
                  marriage = h10_g10,
                  religion = h10_g11,
                  income = p1002_8aq1,
                  code_job=h10_eco9,
                  code_region=h10_reg7)
head(welfare,1)
names(welfare)
welfare$sex
welfare$birth

# 성별에 따른 월급 차이
class(welfare$sex)
table(welfare$sex)
#    1    2 
# 7578 9086 

table(is.na(welfare$sex)) # 결측치 확인

welfare$sex <- ifelse(welfare$sex == 1, 'male','female')
welfare
table(welfare$sex)
qplot(welfare$sex)

# income(월급)
class(welfare$income)
qplot(welfare$income) + xlim(1,1000) # x값 범위지정

summary(welfare$income)

welfare$income <- ifelse(welfare$income %in% c(0:9999),NA,welfare$income)
table(is.na(welfare$income))

sex_income <- welfare %>% filter(!is.na(income)) %>% group_by(sex) %>% summarise(mean_income = mean(income))

sex_income

ggplot(data = sex_income, aes(x=sex, y=mean_income)) + geom_col()
