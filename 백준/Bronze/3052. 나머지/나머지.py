li = []
i = 0
while(i < 10):
    num = int(input())
    li.append(num%42)
    i+=1
print(len(set(li)))
    