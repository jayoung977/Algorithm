li = []
i=0
while(i<28):
    num = int(input())
    li.append(num)
    i +=1
whole_li = [i for i in range(1,31)]
unsubmit_li = sorted(list(set(whole_li)-set(li)))
print(*unsubmit_li)
    