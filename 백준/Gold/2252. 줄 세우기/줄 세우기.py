from collections import deque
N,M = map(int,input().split())
G = [[] for _ in range(N+1)]
indegree = [0]*(N+1)
for _ in range(M):
    a,b = map(int,input().split())
    G[a].append(b)
    indegree[b]+=1

q = deque()
for i in range(1,N+1):
    if indegree[i]==0:
        q.append(i)

while q:
    v = q.popleft()
    print(v, end=" ")
    for nv in G[v]:
        indegree[nv]-=1
        if indegree[nv]==0:
            q.append(nv)