import heapq
INF = int(1e9)
N,K = map(int,input().split())
distance = [INF]*(max(N,K)*2+1)

def dijkstra(start):
    distance[start]=0
    q=[]
    heapq.heappush(q,(0,start))
    while q:
        # print(distance)
        dist, now = heapq.heappop(q)
        if distance[now]<dist:
            continue
        for dd,dn in [(1,-1),(1,1),(0,now)]:
            next_dist = dist+dd
            next_now = now+dn
            if not ( 0<=next_now <=max(N,K)*2) :
                continue
            if distance[next_now]>next_dist:
                distance[next_now]=next_dist
                heapq.heappush(q,(next_dist,next_now))

dijkstra(N)
print(distance[K])