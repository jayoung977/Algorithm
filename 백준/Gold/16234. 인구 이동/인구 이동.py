def dfs(r, c):
    global visited, path, tot
    stack = [(r, c)]
    while stack:
        r, c = stack.pop()
        for d in range(4):
            nr, nc = r + dr[d], c + dc[d]
            if not (0 <= nr < N and 0 <= nc < N) or visited[nr][nc] == 1:
                continue
            if L <= abs(data[nr][nc] - data[r][c]) <= R:
                visited[nr][nc] = 1
                path.append((nr, nc))
                tot += data[nr][nc]
                stack.append((nr, nc))



N,L,R = map(int,input().split())
data = [list(map(int, input().split())) for _ in range(N)]
dr = [-1,0,1,0]
dc = [0,1,0,-1]
answer = 0

while True:
    visited = [[0]*N for _ in range(N)]
    moved = False
    for i in range(N):
        for j in range(N):
            if visited[i][j]!=1:
                visited[i][j]=1
                path = []
                path.append((i,j))
                tot = data[i][j]
                dfs(i,j)
                if len(path)>1:
                    moved = True
                    new_pop = tot//len(path)
                    for r,c in path:
                        data[r][c]=new_pop
    if moved :
        answer+=1
    else:
        print(answer)
        break

# 4 10 40
# 10 20 25 90
# 40 30 30 35
# 10 80 30 75
# 10 80 30 35