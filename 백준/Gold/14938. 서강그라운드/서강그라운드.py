import sys
input = sys.stdin.readline
n, m, r = map(int, input().split())
items = list(map(int, input().split()))
INF = int(1e9)
graph = [[INF]*(n+1) for _ in range(n+1)]
for i in range(1, n+1):
    graph[i][i] = 0

for i in range(r):
    a, b, c = map(int, input().split())
    graph[a][b] = graph[b][a] = c

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])


answer = 0
for i in range(1, n+1):
    score = 0
    for j in range(1, n+1):
        dist = graph[i][j]
        if (dist <= m):
            score += items[j-1]
    answer = max(score, answer)
print(answer)