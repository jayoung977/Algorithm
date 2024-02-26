from collections import deque

n = 0
m = 0
dr = [0,1,0,-1]
dc = [1,0,-1,0]

def bfs(initR,initC,finalR,finalC,maps):
    visited = [[0]*m for _ in range(n)]
    q = deque([(initR,initC)])
    visited[initR][initC] = 1
    result = 0
    while(q):
        size = len(q)
        while(size>0):
            size-=1
            r, c = q.popleft()
            if r == finalR and c == finalC:
                return result
            for d in range(4):
                nr = r+dr[d]
                nc = c+dc[d]
                if not (0<=nr<n and 0<=nc<m):
                    continue

                if maps[nr][nc] == 'X':
                    continue

                if visited[nr][nc] == 0:
                    q.append((nr,nc))
                    visited[nr][nc] = 1
        result+=1
    return -1
            
        



def solution(maps):
    global n,m
    n = len(maps)
    m = len(maps[0])
    # print(maps[0][0])
    startR,startC = 0,0
    leverR , leverC =0,0
    exitR, exitC = 0,0
    for i in range(n):
        for j in range(m):
            if(maps[i][j]=='S'):
                startR,startC = i,j
            if(maps[i][j]=='L'):
                leverR ,leverC=i,j
            if(maps[i][j]=='E'):
                exitR, exitC =i, j
    
    first = bfs(startR,startC,leverR,leverC,maps)
    last =  bfs(leverR,leverC,exitR,exitC,maps)
    if first != -1 and last != -1:
        return first + last
                
    return -1