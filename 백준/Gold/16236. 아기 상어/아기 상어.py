import heapq

N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]
visited = [[False]*N for _ in range(N)]
q = []
for i in range(N):
    for j in range(N):
        if data[i][j] == 9:
            data[i][j] = 0
            heapq.heappush(q, (0, i, j))
            break

dr = [-1, 0, 1, 0]
dc = [0, -1, 0, 1]
size = 2
T = 0
wait = 0
while q:
    d, r, c = heapq.heappop(q)

    if 0 < data[r][c] < size:
        wait += 1
        data[r][c] = 0
        if wait == size:
            size += 1
            wait = 0
        T += d
        d = 0
        q.clear()
        visited = [[False]*N for _ in range(N)]

    for i in range(4):
        nr = r+dr[i]
        nc = c+dc[i]
        if not (0 <= nr < N and 0 <= nc < N):
            continue
        if (not visited[nr][nc]) and data[nr][nc] <= size:
            visited[nr][nc] = True
            heapq.heappush(q, (d+1, nr, nc))


print(T)