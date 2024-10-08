from collections import deque
def solution(maps):
    
    n,m = len(maps),len(maps[0])
    dr,dc = [0,1,0,-1], [-1,0,1,0]
    q = deque([(0,0,1)])
    visited = [[0]*m for _ in range(n)]
    visited[0][0]=1
    answer = -1
    while q:
        r,c,cnt=q.popleft()
        if r==n-1 and c==m-1:
            answer=cnt
            break
        for d in range(4):
            nr,nc=r+dr[d],c+dc[d]
            if not(0<=nr<n and 0<=nc<m):
                continue
            if visited[nr][nc] or not maps[nr][nc]:
                continue
            visited[nr][nc]=1
            q.append((nr,nc,cnt+1))
    return answer