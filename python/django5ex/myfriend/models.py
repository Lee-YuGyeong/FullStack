from django.db import models

# Create your models here.

class Friend(models.Model):
    name = models.CharField(max_length=10)
    address = models.CharField(max_length=20)
    age = models.IntegerField()
