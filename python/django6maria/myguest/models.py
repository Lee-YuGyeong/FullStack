from django.db import models

# Create your models here.
class Guest(models.Model):
    #myno = models.AutoField(auto_create=True, primary_key = True)
    title = models.CharField(max_length=50)
    content = models.TextField()
    regdate = models.DateField()
    
    def __str__(self):
        return self.title
    
    class Meta:
        ordering = ('-id',) # 정렬 방법중 하나