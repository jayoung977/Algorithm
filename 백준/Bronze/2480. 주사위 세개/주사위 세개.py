li = list(map(int,input().split()))

max_count = 0
for num in li:
    if (max_count < li.count(num)):
        max_count = li.count(num)
        max_num = num
if max_count == 3:
    print(10000+max_num*1000)
elif max_count == 2:
    print(1000+max_num*100)
else:
    print(max(li)*100)
    
     
        

