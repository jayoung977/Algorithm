from collections import deque

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


def bfs(r, c):
    visited[r][c] = True
    q = deque([(r, c)])
    q_united = deque([(r, c)])
    while (len(q) > 0):
        r, c = q.pop()
        # print("R,c:(", r, c, ")")
        population = data[r][c]
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if (not (0 <= nr < N and 0 <= nc < N)):
                continue
            if (visited[nr][nc]):
                continue
            if (L <= abs(data[nr][nc]-population) <= R):
                visited[nr][nc] = True
                q.append((nr, nc))
                q_united.append((nr, nc))
            # print(data[nr][nc], population)
            # print(abs(data[nr][nc]-population))
            # if(L<=abs(data[nr][nc]-population)<=R):
    # print(q_united)
    if (len(q_united) > 1):
        sum_pop = 0
        for r, c in q_united:
            sum_pop += data[r][c]
        new_population = int(sum_pop/len(q_united))
        # print("new_population:", new_population)
        for r, c in q_united:
            data[r][c] = new_population
        # print(data)
        return True

    return False


N, L, R = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
# print(data)
# BFS

cnt = 0
while (True):
    visited = [[False] * N for _ in range(N)]
    flag = False
    for i in range(N):
        for j in range(N):
            if (visited[i][j]):
                continue
            if (bfs(i, j)):  # 한번이라도 인구 이동 있다면
                flag = True
    if (not flag):
        break
    cnt += 1

print(cnt)