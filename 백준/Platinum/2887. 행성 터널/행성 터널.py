from heapq import heappop,heappush
N = int(input())
hangsungs = [list(map(int,input().split()))+[i] for i in range(N)]


q = []
visited = [0]*(N)
G = [[] for _ in range(N)]

for i in range(3):
    hangsungs.sort(key=lambda x:x[i])
    for a,b in zip(hangsungs,hangsungs[1:]):
        G[a[3]].append((abs(a[i]-b[i]),b[3]))
        G[b[3]].append((abs(a[i]-b[i]),a[3]))

heappush(q,(0,0))
ans = 0
cnt = 0
while cnt < N:
    w,v = heappop(q)
    if visited[v]:
        continue
    visited[v]=1
    ans+=w
    cnt+=1
    for nw,nv in G[v]:
        heappush(q,(nw,nv))
print(ans)