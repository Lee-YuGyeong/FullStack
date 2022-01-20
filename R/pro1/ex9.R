library(XML)
library(methods)

xmlData <- xmlTreeParse("score.xml", useInternalNodes = T)
rootNode <- xmlRoot(xmlData)
rootNode
names <- xpathSApply(rootNode, "//name", xmlValue)
names
scores <- xpathSApply(rootNode, "//score", xmlValue)
scores
scoredf <- data.frame(names,scores)
scoredf
