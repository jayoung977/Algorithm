a, n  = map(int,input().split())

cnt = 0 
for i in range(a):
    i = i+1 #1부터 n까지
    if a % i == 0:
        cnt += 1
        if cnt == n:
            print(i)
if cnt < n:
    print(0)