from collections import deque,Counter
def solution(n, edge):
    answer = 0
    nodes = [[] for _ in range(n+1)]
    for a,b in edge:
        nodes[a].append(b)
        nodes[b].append(a)
    
    visited = [0]*(n+1)
    queue = deque()
    queue.append((1,0))
    visited[1]=1
    while queue:
        node, cnt = queue.popleft()
        for nex in nodes[node]:
            if visited[nex]==0:
                queue.append((nex,cnt+1))
                visited[nex]=cnt+1    
    return Counter(visited)[max(visited)]