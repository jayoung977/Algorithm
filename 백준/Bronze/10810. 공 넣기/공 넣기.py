import sys
total_basket, total_num = map(int,input().split())
li = [0 for i in range(total_basket)]
i = 0
while(i < total_num):
    first_n,last_n,num = map(int,sys.stdin.readline().split())
    for j in range(first_n,last_n+1): 
        li[j-1] = num
    i +=1
print(*li)       
        
    
    