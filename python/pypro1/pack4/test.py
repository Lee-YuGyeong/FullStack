hap = 0
i=1
cnt=0
while True:
    if i==101: break
    if i%2==0:
        hap+=i
        cnt+=1
    i+=1
print(hap,cnt)