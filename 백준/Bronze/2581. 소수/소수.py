m =  int(input())
n =  int(input())

# sum = 0
# first = 0
li = []
for num in range(m,n+1):
    cnt = 0
    if num > 1:
        for i in range(2,num):
            if num %i ==0:
                cnt +=1
                break
        if cnt == 0:
            li.append(num)
            # sum+=num
            # first +=1
        # if first ==1:
        #     first_num =  num

if len(li) == 0:
    print(-1)

else:
    print(sum(li))
    print(min(li))