import copy


def move_fish():
    res = [[[] for _ in range(4)] for _ in range(4)]
    for r in range(4):
        for c in range(4):
            while temp[r][c]:
                d = temp[r][c].pop()
                for i in range(d, d - 8, -1):
                    i %= 8
                    nr, nc = r + dr[i], c + dc[i]
                    if (nr, nc) != shark and 0 <= nr < 4 and 0 <= nc < 4 and not smell[nr][nc]:
                        res[nr][nc].append(i)
                        break
                else:
                    res[r][c].append(d)
    return res


def dfs(r, c, dep, cnt, visit):
    global max_eat, shark, eat
    if dep == 3:   # 3번 이동한 경우 그만
        if max_eat < cnt:
            max_eat = cnt
            shark = (r, c)
            eat = visit[:]
        return
    for d in range(4):
        nr = r + drr[d]
        nc = c + dcc[d]
        if 0 <= nr < 4 and 0 <= nc < 4:
            if (nr, nc) not in visit:  # 처음 방문, cnt에 죽은 물고기 수 추가
                visit.append((nr, nc))
                dfs(nr, nc, dep + 1, cnt + len(temp[nr][nc]), visit)
                visit.pop()
            else:  # 방문한 경우
                dfs(nr, nc, dep + 1, cnt, visit)


#       ←, ↖,   ↑,  ↗, →, ↘, ↓, ↙
dr = [0, -1, -1, -1, 0, 1, 1, 1]
dc = [-1, -1, 0, 1, 1, 1, 0, -1]
drr = [-1, 0, 1, 0]
dcc = [0, -1, 0, 1]

m, s = map(int, input().split())
fish = [list(map(int, input().split())) for _ in range(m)]
graph = [[[] for _ in range(4)] for _ in range(4)]

for r, c, d in fish:
    graph[r - 1][c - 1].append(d - 1)

shark = tuple(map(lambda x: int(x) - 1, input().split()))
smell = [[0] * 4 for _ in range(4)]

for _ in range(s):
    eat = list()
    max_eat = -1
    # 1. 모든 물고기 복제
    temp = copy.deepcopy(graph)
    # 2. 물고기 이동
    temp = move_fish()
    # 3. 상어이동 - 백트래킹
    dfs(shark[0], shark[1], 0, 0, list())
    for r, c in eat:
        if temp[r][c]:
            temp[r][c] = []
            smell[r][c] = 3   # 3번 돌아야 없어짐
    # 4. 냄새 사라짐
    for i in range(4):
        for j in range(4):
            if smell[i][j]:
                smell[i][j] -= 1
    # 5. 복제 마법
    for i in range(4):
        for j in range(4):
            graph[i][j] += temp[i][j]

# 물고기 수 구하기
answer = 0
for i in range(4):
    for j in range(4):
        answer += len(graph[i][j])

print(answer)
