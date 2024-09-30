from collections import deque

def solution(board):
    dr,dc= [-1,0,1,0],[0,1,0,-1]
    m,n=len(board),len(board[0])
    def check(r,c):
        return 0<=r<m and 0<=c<n
    
    visited = [[0]*n for _ in range(m)]
    start,end = [],[]
    for i in range(m):
        for j in range(n):
            if board[i][j]=="R":
                start.extend([i,j])
    q = deque()
    q.append([start[0],start[1],0])
    visited[start[0]][start[1]]=1
    while q:
        r,c,cnt = q.popleft()
        if board[r][c]=="G":
            return cnt
        for d in range(4):
            nr,nc = r+dr[d],c+dc[d]
            while check(nr,nc) and board[nr][nc]!="D":
                nr+=dr[d]
                nc+=dc[d]
            nr-=dr[d]
            nc-=dc[d]
            if visited[nr][nc]==1:
                continue
            visited[nr][nc]=1
            q.append([nr,nc,cnt+1])
                
    
    
    return -1