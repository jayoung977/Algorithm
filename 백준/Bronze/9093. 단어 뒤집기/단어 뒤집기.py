t = int(input())
for i in range(t):
    li = list(map(lambda x: x[::-1], input().split()))
    print(' '.join(li))
