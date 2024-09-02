import heapq
M,N = map(int,input().split())
graph = [list(map(int,list(input()))) for _ in range(N)]
INF = int(1e9)
distance = [[INF]*M for _ in range(N)]
dr = [-1,0,1,0]
dc = [0,1,0,-1]

def dijkstra(start_r,start_c):
    distance[start_r][start_c]=0
    q=[]
    heapq.heappush(q,(0,(start_r,start_c)))
    while q:
        dist,(r,c)=heapq.heappop(q)
        if dist>distance[r][c]:
            continue
        for d in range(4):
            nr,nc=r+dr[d],c+dc[d]
            if not (0<=nr<N and 0<=nc<M):
                continue
            next_dist=dist+graph[nr][nc]
            if distance[nr][nc]>next_dist:
                distance[nr][nc]=next_dist
                heapq.heappush(q,(next_dist,(nr,nc)))

dijkstra(0,0)
print(distance[N-1][M-1])