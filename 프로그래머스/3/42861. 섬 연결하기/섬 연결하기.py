from heapq import heappop,heappush
def solution(n, costs):
    
    graph = [[] for _ in range(n)]
    for s,e,cost in costs:
        graph[s].append((e,cost))
        graph[e].append((s,cost))
    
    hq = []
    heappush(hq,(0,0))
    visited=set()
    answer = 0
    cnt = 1
    while hq and cnt<=n:
        cost,v = heappop(hq)
        if v in visited:
            continue
        visited.add(v)
        answer+=cost
        cnt+=1
        for nv,ncost in graph[v]:
            heappush(hq,(ncost,nv))
                
        
        
        
        
    return answer