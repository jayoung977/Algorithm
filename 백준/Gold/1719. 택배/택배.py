import sys
input = sys.stdin.readline

n, m = map(int, input().split())
INF = int(1e9)
graph = [[INF]*(n+1) for _ in range(n+1)]
answer = [[0]*(n+1) for _ in range(n+1)]
for i in range(n+1):
    graph[i][i] = 0
    answer[i][i] = "-"

for i in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c


for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            if (graph[a][b] > graph[a][k]+graph[k][b]):
                graph[a][b] = graph[a][k]+graph[k][b]
                if (answer[a][k] != 0):
                    answer[a][b] = answer[a][k]
                else:
                    answer[a][b] = k

for i in range(1, n+1):
    for j in range(1, n+1):
        if answer[j][i] == 0:
            answer[j][i] = i

for i in range(1, n+1):
    for j in range(1, n+1):
        print(answer[i][j], end=" ")
    print()