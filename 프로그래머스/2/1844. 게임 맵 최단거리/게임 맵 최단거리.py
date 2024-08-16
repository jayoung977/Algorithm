from collections import deque
dr = [-1,0,1,0]
dc = [0,1,0,-1]
def solution(maps):
    answer = 0
    m,n = len(maps),len(maps[0])
    queue = deque()
    visited = [[False]*n for _ in range(m)]
    queue.append((0,0,1))
    visited[0][0]=True
    while queue:
        r,c,cnt = queue.popleft()
        # print(r,c,cnt)
        answer = max(cnt,answer)
        for d in range(4):
            nr = r+dr[d]
            nc = c+dc[d]
            if not(0<=nr<m and 0<=nc<n):
                continue
            if not visited[nr][nc] and maps[nr][nc]==1:
                if nr==m-1 and nc==n-1:
                    return cnt+1
                visited[nr][nc]=True
                queue.append((nr,nc,cnt+1))
            
    return -1