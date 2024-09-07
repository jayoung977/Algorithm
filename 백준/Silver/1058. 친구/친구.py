N = int(input())
G = [list(input()) for _ in range(N)]
V = [[0]*N for _ in range(N)]

for k in range(N):
    for a in range(N):
        for b in range(N):
            if a == b:
                continue
            if G[a][b]=="Y" or (G[a][k]=="Y" and G[k][b]=="Y"):
                V[a][b]=1

answer = 0
for row in V:
    answer = max(sum(row),answer)

print(answer)