from heapq import heappop,heappush
def solution(n, costs):
    graph = [[] for _ in range(n)]
    for s,e,w in costs:
        graph[s].append((e,w))
        graph[e].append((s,w))
    hq= []
    heappush(hq,(0,0))
    visited = set()
    cnt = n
    answer = 0
    while cnt>0 :
        w,n = heappop(hq)
        if n in visited:
            continue
        visited.add(n)
        answer+=w
        for nn,nw in graph[n]:  
            heappush(hq,(nw,nn))
        
        cnt-=1
        
        
    return answer