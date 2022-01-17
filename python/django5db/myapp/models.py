from django.db import models

# Create your models here.
# 테이블을 클래스로 정의

class Article(models.Model):
    code = models.CharField(max_length=10)
    name = models.CharField(max_length=20)
    price = models.IntegerField()
    pub_date = models.DateTimeField()
