# dplyr이 지원하는 filter
library(dplyr)
stu <- read.csv("testdata/ex_studentlist.csv")

dplyr::filter(stu, gender == '남') # and
filter(stu, gender == '남' | grade == 2) # or
length(filter(stu, gender == '남' | grade == 2))

arrange(stu, age) # 나이별 정렬
arrange(stu, desc(age))
arrange(stu, grade, age)

select(stu, name, age) # 열 추출
select(stu, name:age)
select(stu, -(name:age))

# %>% 파이프 연산자 : 명령을 연속적으로 이어 적어 줄 수 있다
stu %>% filter(grade == 1)
stu %>% filter(grade != 1)
stu %>% filter(height >= 170)
stu %>% filter(height >= 170 & grade ==2 ) # and
stu %>% filter(height >= 170 | grade ==2 ) # or
stu %>% filter(grade %in% c(1:2))

stu %>% select(name, bloodtype )
