from itertools import combinations

def isFind(r,c):
    d = 0
    while d < 4:
        nr,nc = r+dr[d],c+dc[d]
        while True:
            if not(0<=nr<N and 0<=nc<N):
                break
            if data[nr][nc]=="O":
                break
            elif data[nr][nc]=="S":
                return True
            nr+=dr[d]
            nc+=dc[d]
        d+=1
    return False

def solution(N,data):
    T_list, X_list = [],[]
    for i in range(N):
        for j in range(N):
            if data[i][j]=="S":
                continue
            elif data[i][j]=="T":
                T_list.append((i,j))
                continue
            X_list.append((i,j))
    for combi in combinations(X_list,3):
        #넣기
        for r,c in combi:
            data[r][c]="O"
        flag = True
        for r,c in T_list:
            if isFind(r,c):
                flag=False
                break
        if flag:
            return "YES"
        #뺴기
        for r,c in combi:
            data[r][c]="X"
            

    return "NO"




N = int(input())
data = [list(input().split()) for _ in range(N)]
dr = [-1,0,1,0]
dc = [0,1,0,-1]
print(solution(N,data))