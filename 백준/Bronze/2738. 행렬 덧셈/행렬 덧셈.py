n, m =  map(int,input().split())

a = [ [0 for i in range(m)] for j in range(n)]
b = [ [0 for i in range(m)] for j in range(n)]
new = [ [0 for i in range(m)] for j in range(n)]
for i in range(n*2):
    li = list(map(int,input().split()))
    for j in range(m):
        if i < n:
            a[i][j] = li[j]
        else:
            b[i-n][j] = li[j]


for i in range(n):
    for j in range(m):
        new[i][j] = a[i][j] +b[i][j]
    print((' '.join(map(str,new[i]))))