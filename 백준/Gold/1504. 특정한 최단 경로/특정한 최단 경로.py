import heapq
INF=int(1e9)
N,E = map(int, input().split())
graph = [[] for _ in range(N+1)]
for _ in range(E):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
v1,v2 = map(int,input().split())
v1_v2_cost=INF
for (node, cost) in graph[v1]:
    if node==v2:
        v1_v2_cost=cost

def dijkstra(start):
    distance = [INF]*(N+1)
    distance[start]=0
    q=[]
    heapq.heappush(q,(0,start))
    while q:
        dist,now = heapq.heappop(q)
        if distance[now]<dist:
            continue
        for next_node, next_cost in graph[now]:
            next_dist = dist+next_cost
            if next_dist<distance[next_node]:
                distance[next_node]=next_dist
                heapq.heappush(q,(next_dist,next_node))
    return distance

start_1=dijkstra(1)
start_v1=dijkstra(v1)
start_v2=dijkstra(v2)

path_1_v1_v2_N = start_1[v1]+start_v1[v2]+start_v2[N]
path_1_v2_v1_N = start_1[v2]+start_v2[v1]+start_v1[N]
result = min(path_1_v1_v2_N,path_1_v2_v1_N)
if result >= INF:
    print(-1)
else:
    print(result)