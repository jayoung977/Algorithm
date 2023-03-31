a = list(input())
li = []
n = len(a) 

for i in range((n//2)+1):  
    if a[i] == a[-1-i]: 
        li.append(1)
    else:
        li.append(0)
        
print(min(li))


