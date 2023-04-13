n= int(input())


for i in range(1,n+1):
    li = map(int, list(str(i))) #각 자리수 리스트
    total_sum = i + sum(li)
    if total_sum == n:
        m = i
        break
try:
    print(m)
except:
    print(0)