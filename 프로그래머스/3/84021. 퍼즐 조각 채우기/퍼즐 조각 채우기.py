def solution(game_board, table):
    def dfs(r,c,value,graph,visited,path):
        stack=[(r,c)]
        while stack:
            r,c=stack.pop()
            for d in range(4):
                nr,nc=r+dr[d],c+dc[d]
                if not(0<=nr<n and 0<=nc<n):
                    continue
                if visited[nr][nc] or graph[nr][nc]!=value:
                    continue
                visited[nr][nc]=1
                path+=[(nr,nc)]
                stack.append((nr,nc))
        return
    
    def toblock(blocks):
        nblocks=[]
        for block in blocks:
            minr,minc,maxr,maxc=n,n,0,0
            for r,c in block:
                minr,minc = min(r,minr),min(c,minc)
                maxr,maxc = max(r,maxr),max(c,maxc)
            fr,fc = maxr-minr+1,maxc-minc+1
            nblock=[[0]*fc for _ in range(fr)]
            for r,c in block:
                nblock[r-minr][c-minc]=1
            nblocks.append((nblock,len(block)))
        return nblocks
    
    def rotate(block):
        m,n=len(block),len(block[0])
        nblock=[[0]*m for _ in range(n)]
        for i in range(m):
            for j in range(n):
                nblock[j][m-1-i]=block[i][j]
        return nblock
            
                
    answer = 0
    n= len(game_board)
    gvisited= [[0]*n for _ in range(n)]
    tvisited= [[0]*n for _ in range(n)]
    gblocks,tblocks = [],[]
    dr,dc = [-1,0,1,0],[0,1,0,-1]
    for i in range(n):
        for j in range(n):
            if not gvisited[i][j] and game_board[i][j]==0:
                gvisited[i][j]=1
                gpath=[(i,j)]
                dfs(i,j,0,game_board,gvisited,gpath)
                gblocks.append(gpath)
            if not tvisited[i][j] and table[i][j]==1:
                tvisited[i][j]=1
                tpath=[(i,j)]
                dfs(i,j,1,table,tvisited,tpath)
                tblocks.append(tpath)
                
    gblocks,tblocks = toblock(gblocks),toblock(tblocks)
    usedblock=set()
    
    for (emptyblock,gn) in gblocks:
        findflag=False
        for i,(block,tn) in enumerate(tblocks):
            if i in usedblock or gn!=tn:
                continue
            
            rotatedblock=block
            for _ in range(4):
                rotatedblock=rotate(rotatedblock)
                if emptyblock == rotatedblock:
                    usedblock.add(i)
                    answer+=gn
                    findflag=True
                    break
            if findflag:
                break
                
    return answer