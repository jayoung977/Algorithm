def solution(maps):
    m,n = len(maps),len(maps[0])
    visited = [[0]*n for _ in range(m)]
    dr,dc = [-1,0,1,0],[0,1,0,-1]

    def dfs_stack(r,c):
        day = int(maps[r][c])
        stack = []
        stack.append([r,c])
        while stack:
            r,c = stack.pop()
            for d in range(4):
                nr,nc=r+dr[d],c+dc[d]
                if not(0<=nr<m and 0<=nc<n) or visited[nr][nc] or maps[nr][nc]=="X":
                    continue
                visited[nr][nc]=1
                stack.append([nr,nc])
                day+=int(maps[nr][nc])
                
        return day
            
    answer = []
    for i in range(m):
        for j in range(n):
            if maps[i][j]!="X" and visited[i][j]==0 :
                visited[i][j]=1
                total_days = dfs_stack(i,j)
                answer.append(total_days)
    if not answer:
        return [-1]
    answer.sort()
    return answer