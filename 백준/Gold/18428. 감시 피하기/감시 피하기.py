import copy


def combi(start, r, chosen):
    global combi_list
    if (len(chosen) == r):
        combi_list.append(chosen[:])
        return
    for i in range(start, len(X_arr)):
        chosen.append(X_arr[i])
        combi(i+1, r, chosen)
        chosen.pop()


dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


def check(r, c):
    idx = 0
    nr = r
    nc = c
    while (idx < 4):
        nr += dr[idx]
        nc += dc[idx]
        # print(nr, nc)
        if (not (0 <= nr < N and 0 <= nc < N)):
            idx += 1
            nr = r
            nc = c
            continue
        if (temp[nr][nc] == 'O'):
            idx += 1
            nr = r
            nc = c
            continue
        if (temp[nr][nc] == 'S'):
            return False
    return True


N = int(input())
data = [list(input().split()) for _ in range(N)]
X_arr = [(r, c) for r in range(N) for c in range(N) if data[r][c] == 'X']
T_arr = [(r, c) for r in range(N) for c in range(N) if data[r][c] == 'T']

answer = "NO"

# 조합
combi_list = []
# 다시
combi(0, 3, [])

# test
# combi_list = [[(0, 3), (1, 1), (2, 2)]]
# check
for chosen in combi_list:
    temp = copy.deepcopy(data)
    # O표시
    for r, c in chosen:
        temp[r][c] = 'O'
    # for i in range(N):
        # print(temp[i])
    isNo = False
    # 선생님이면 DFS
    for r, c in T_arr:
        if (not check(r, c)):
            isNo = True
            break
    if (isNo):
        continue
    else:
        answer = "YES"
        break
print(answer)
# 5
# X S X X T
# T X S X X
# X X X X X
# X T X X X
# X X T X X