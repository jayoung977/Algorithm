from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[-1]*102 for _ in range(102)]
    visited = [[0]*102 for _ in range(102)]
    
    for elem in rectangle:
        lx,ly,rx,ry = map(lambda x: x*2, elem)
        for x in range(lx,rx+1):
            for y in range(ly,ry+1):
                if lx<x<rx and ly<y<ry:
                    graph[y][x]=0
                elif graph[y][x]!=0:
                    graph[y][x]=1
    
    dx = [-1,0,1,0]
    dy = [0,-1,0,1]
    
    queue = deque()
    queue.append((characterX*2, characterY*2))
    
    while queue:
        x,y = queue.popleft()
        if x == itemX*2 and y == itemY*2:
            return visited[y][x]//2
        for i,j in zip(dx,dy):
            nx,ny = x+i, y+j
            if not (0<=nx<102 and 0<=ny<102) :
                continue
            if visited[ny][nx]==0 and graph[ny][nx]==1:
                visited[ny][nx]=visited[y][x]+1
                queue.append((nx, ny))
        
    return answer