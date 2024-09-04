N = int(input())
M = int(input())
Edges = []
for _ in range(M):
    a,b,c = map(int,input().split())
    Edges.append((c,a,b))
Edges.sort()
parent = [i for i in range(N+1)]

def find(parent,x):
    if parent[x]!=x:
        parent[x]=find(parent,parent[x])
    return parent[x]

def union(parent,a,b):
    a = find(parent,a)
    b = find(parent,b)
    if a<b:
        parent[b]=a
        return
    parent[a]=b
    return

ans = 0
for c,a,b in Edges:
    if find(parent,a)!=find(parent,b):
        union(parent,a,b)
        ans+=c
        
print(ans)