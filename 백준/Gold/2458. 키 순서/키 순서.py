import sys
input = sys.stdin.readline
n, m = map(int, input().split())

graph = [[0]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            if graph[a][k] == 1 and graph[k][b] == 1:
                graph[a][b] = 1

answer = 0
for i in range(1, n+1):
    check = 0
    for j in range(1, n+1):
        check += (graph[i][j] + graph[j][i])
    if check == (n-1):
        answer += 1

print(answer)