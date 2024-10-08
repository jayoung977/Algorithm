from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    n=51*2
    graph = [[-1]*n for _ in range(n)]
    visited = [[0]*n for _ in range(n)]
    dr,dc = [0,1,0,-1],[-1,0,1,0]
    answer = 0
    for rect in rectangle:
        lx,ly,rx,ry = map(lambda x:x*2, rect)
        for y in range(ly,ry+1):
            for x in range(lx,rx+1):
                if ly<y<ry and lx<x<rx:
                    graph[y][x]=0
                elif graph[y][x]!=0:
                    graph[y][x]=1
                    
    characterX, characterY =  characterX*2, characterY*2
    itemX, itemY =  itemX*2, itemY*2
    
    q = deque([(characterY, characterX,0)])
    visited[characterY][characterX]=1
    
    while q:
        r,c,cnt=q.popleft()
        if r == itemY and c == itemX:
            answer=cnt//2
            break
        for d in range(4):
            nr,nc = r+dr[d], c+dc[d]
            if not (0<=r<n and 0<=c<n):
                continue
            if visited[nr][nc]==1 or graph[nr][nc]!=1:
                continue
            visited[nr][nc]=1
            q.append((nr,nc,cnt+1))
                
    return answer