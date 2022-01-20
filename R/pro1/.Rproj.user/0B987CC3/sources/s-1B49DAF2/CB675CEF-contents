# web scraping
install.packages("XML")
library(XML)
install.packages("httr")
library(httr)

url <- "https://www.melon.com/song/popup/lyricPrint.htm?songId=11111"
source <- htmlParse(rawToChar(GET(url=url)$content))
source

lyrics <- xpathSApply(source, "//div[@class='box_lyric_text']", xmlValue)
lyrics

lyrics <- gsub("[\r\n\t]","",lyrics)
lyrics


# 다음 사이트의 뉴스 정보 제목 읽기
durl <- "https://news.daum.net/"
doc <- htmlParse(rawToChar(GET(url=durl)$content))
doc

doc <- xpathSApply(doc, "//a[@class='link_txt']", xmlValue)
doc

result <- gsub("[\r\n\t]","",doc)
result <- gsub("[[:punct:]]","",doc) # 문장 부호 제거
result <- gsub("[[:cntrl:]]","",doc) # 특수 문자 제거
result <- gsub("\\d+","",doc) # 숫자 제거
result <- gsub("\\s+"," ",doc) # 두개이상의 공백을 공백 하나로
result
