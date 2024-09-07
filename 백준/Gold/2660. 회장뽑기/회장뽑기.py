from heapq import heappop,heappush
N = int(input())
G = [[] for _ in range(N+1)]
INF = int(1e9)
while True:
    a,b = map(int,input().split())
    if a == -1 and b == -1:
        break
    G[a].append((b,1))
    G[b].append((a,1))

distance = [ [INF]*(N+1) for _ in range(N+1) ]

# for row in distance:
#     print(row)
candidate = []

def dijkstra(start):
    # print("start:{}".format(start))
    q = []
    heappush(q,(0,start))
    distance[start][start]=0
    while q:
        d,v = heappop(q)
        # print("d:{},v:{},distance[start]:{}".format(d,v,distance[start]))
        if distance[start][v] < d:
            continue
        for nv,nw in G[v]:
            # print("nv:{},nw:{}".format(nv,nw))
            nd = d+nw
            if nd < distance[start][nv]:
                distance[start][nv] = nd
                heappush(q,(nd,nv))
    # print(distance[start][1:])
    heappush(candidate,(max(distance[start][1:]),start))

for i in range(1,N+1):
    dijkstra(i)

first_score,first_hubo = heappop(candidate)
cnt = 1
hubo_list = [first_hubo]

while candidate and candidate[0][0]==first_score:
    score,hubo= heappop(candidate)
    cnt+=1
    hubo_list.append(hubo)

hubo_list.sort()
print(first_score,len(hubo_list))
print(" ".join(map(str,hubo_list)))