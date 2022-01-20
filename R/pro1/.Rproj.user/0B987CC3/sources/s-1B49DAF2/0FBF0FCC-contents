# 데이터의 종류
# 정형 : RDBMS
# 반정형 : html, xml...
# 비정형 : sns...

# RDBMS와 연동 : RJDBC 패키지 사용 - 자바로 작성됨
install.packages("DBI")
install.packages("RJDBC")

library(rJava)
library(DBI)
library(RJDBC)

# 개인용 데이터베이스 SQLite
install.packages("RSQLite")
library(RSQLite)

mtcars # 기본 dataset 중 하나인데 여기서는 테이블의 자료로 사용할 예정
names(mtcars)
is(mtcars)

conn <- dbConnect(RSQLite::SQLite(),":memory:")
conn

dbWriteTable(conn = conn, name = "mtcars", mtcars)
dbWriteTable(conn = conn, name = "iris", iris)
dbListTables(conn) # 테이블 목록 보기
sql <- "select * from mtcars"
goodsAll <- dbGetQuery(conn, sql)
goodsAll

sql <- "select mpg, cyl, gear from mtcars where mpg > 30"
goodsAll <- dbGetQuery(conn,sql)
goodsAll

dbDisconnect(conn) # 연결 해제

# -----원격 Database (MariaDB) -------------------------------------
drv <- JDBC(driverClass = "org.mariadb.jdbc.Driver", classPath = "mariadb-java-client-2.6.2.jar")
drv

conn <- dbConnect(drv = drv, "jdbc:mysql://127.0.0.1:3306/test","root","123")
conn
dbListTables(conn)

sql2 = "select * from sangdata"
sangAll <- dbGetQuery(conn,sql2)
sangAll
is(sangAll)
mean(sangAll$su)
barplot(sangAll$su, col = rainbow(5), names.arg = sangAll$sang)

sql2 = "select * from sangdata where sang like '가죽%'"
sangAll <- dbGetQuery(conn,sql2)
sangAll


sql2 = "select code, sang from sangdata order by code desc"
sangAll <- dbGetQuery(conn,sql2)
sangAll

# 레코드 추가
isql = "insert into sangdata values(12, '선물' , 5, 5000)"
dbSendUpdate(conn, isql)

df <- data.frame(code=13, sang='종이컵',su=12, dan=100)
df

dbSendUpdate(conn, "insert into sangdata values(?,?,?,?)", df$code, df$sang, df$su, df$dan)

dbGetQuery(conn,"select * from sangdata")

#레코드 수정
usql = "update sangdata set sang='연습', su = 77 where code=13"
dbSendQuery(conn, usql)

dbSendUpdate(conn,"update sangdata set sang=? where code=13","컴퓨터")
dbGetQuery(conn,"select * from sangdata")

# 레코드 삭제
dbSendUpdate(conn, "delete from sangdata where code=?",13)
dbGetQuery(conn, "select * from sangdata")

# 레코드 추가시 data.frame에 있는 여러개의 행(관측값)이 있는 경우 함수를 작성해서 처리
paste("Hi","everybody")
paste("Hi","everybody")

# 레코드 추가시 data.frame에 있는 여러개의 행(관측값)
library(dplyr) # %>% 사용

sangdf <- read.csv('sangpum.csv', header = T, fileEncoding = "UTF-8")
sangdf

func <- function(conn, table,df){
  batch <- apply(df, 1, FUN = function(x) paste0("'", trimws(x), "'", collapse=",")) %>% paste0("(",.,")", collapse=",\n")
  
  #batch "('100','자바','3','25000'),\n('101','오라클','13','35000'),\n('102','파이썬','23','45000')"
  
  sql <- paste("insert into", table, "value", batch) # sql문을 완성
  dbSendUpdate(conn,sql)
}
func(conn, "sangdata", sangdf)

dbGetQuery(conn,"select * from sangdata")

dbDisconnect(conn) # DB 연결 해제
