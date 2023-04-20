n =  int(input())
cnt = 0

max_i = n // 5 + 1
max_j = n // 3 + 1
li = []
for i in range(max_i):
    for j in range(5000):
        if 5*i + 3*j == n:
            li.append(i+j)

if (li != []):
    print(min(li))
else:
    print(-1)