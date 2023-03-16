num = int(input())
i = 0
li = []
while(i < num): 
    whole_li = list(input().split())
    li.append(whole_li)
    i+=1
    
for l in li:
    n = int(l[0])
    word = list(l[1])
    li2 = []
    for j in word:
        li2.append(j*n)
    print(''.join(li2))

