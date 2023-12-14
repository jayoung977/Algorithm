import heapq
n, m, x = map(int, input().split())
INF = int(1e9)
graph = [[] for _ in range(n+1)]
distance_2d = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


for start in range(1, n+1):
    distance = [INF]*(n+1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue
        for i in graph[now]:
            cost = i[1]+dist
            if (cost < distance[i[0]]):
                heapq.heappush(q, (cost, i[0]))
                distance[i[0]] = cost
    distance_2d[start] = distance

answer = 0
for i in range(1, n+1):
    student_cost = distance_2d[i][x] + distance_2d[x][i]
    answer = max(student_cost, answer)
print(answer)