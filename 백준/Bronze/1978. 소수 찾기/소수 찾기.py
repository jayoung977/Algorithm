n =  int(input())
li = list(map(int,input().split()))

cnt2 = 0
for num in li:
    cnt = 0
    for i in range(num-1): #자기자신 제외
        i +=1 
        if num % i == 0:
            cnt +=1
    if cnt == 1:
        cnt2 +=1
print(cnt2)