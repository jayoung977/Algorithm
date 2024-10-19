from heapq import heappush,heappop
def solution(n, edge):
    graph = [[] for _ in range(n+1)] #1번부터
    for s,e in edge:
        graph[s].append(e)
        graph[e].append(s)
    
    distance = [int(1e9)]*(n+1) #0번 있음 조심
    distance[1]=0
    hq = []
    heappush(hq,(0,1))
    while hq:
        dist,node = heappop(hq)
        if distance[node]<dist:
            continue
        for nnode in graph[node]:
            ndist = dist+1
            if ndist<distance[nnode]:
                distance[nnode]=ndist
                heappush(hq,(ndist,nnode))
    max_d = max(distance[1:])
    answer = 0
    for i in range(1,len(distance)):
        if distance[i]==max_d:
            answer+=1
        
                
        
    
    
    
    
        
    
    return answer