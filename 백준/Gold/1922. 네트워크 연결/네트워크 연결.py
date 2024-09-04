from heapq import heappush,heappop
N = int(input())
M = int(input())
G = [[] for _ in range(N+1)]
for _ in range(M):
    a,b,c = map(int,input().split())
    G[a].append((b,c))
    G[b].append((a,c))

def prim(start):
    q = []
    visited = [0]*(N+1)
    heappush(q,(0,start))
    cnt = 0
    ans = 0
    while cnt < N:
        w,v = heappop(q)
        if visited[v]:
            continue
        visited[v]=1
        ans+=w
        cnt+=1
        for nv,nw in G[v]:
            heappush(q,(nw,nv))

    return ans
print(prim(1))