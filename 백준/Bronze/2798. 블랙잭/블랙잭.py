n,m = map(int,input().split())
cards = list(map(int,input().split()))


li = []
for i in range(n):
    for j in range(n):
        for k in range(n):
            if i!=j and j!=k and k!=i:
                sum = cards[i]+cards[j]+cards[k]
                if sum <= m:
                    li.append(sum)
print(max(li))