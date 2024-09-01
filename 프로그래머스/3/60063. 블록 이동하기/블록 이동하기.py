from collections import deque
def solution(board):

    N = len(board)
    new_board = [[1]*(N+2) for _ in range(N+2)]
    for i in range(N):
        for j in range(N):
            new_board[i+1][j+1]=board[i][j]
    
    visited = set([((1,1),(1,2))])

    queue = deque([(((1,1),(1,2)),0)])
    dr,dc = [0,1,0,-1], [1,0,-1,0]
    
    def next_pos(pos):
        (r1,c1),(r2,c2) = pos
        next_poses = []
        if r1==r2: #가로
            for i in [-1,1]:
                if (new_board[r1+i][c1]!=1 and new_board[r2+i][c2]!=1):
                    next_poses.append(((r1,c1),(r1+i,c1)))
                    next_poses.append(((r2,c2),(r2+i,c2)))
        else: 
            for i in [-1,1]:
                if (new_board[r1][c1+i]!=1 and new_board[r2][c2+i]!=1):
                    next_poses.append(((r1,c1),(r1,c1+i)))
                    next_poses.append(((r2,c2),(r2,c2+i)))
                    
        for d in range(4):
            nr1,nc1,nr2,nc2 = r1+dr[d], c1+dc[d], r2+dr[d], c2+dc[d]   
            if new_board[nr1][nc1]==0 and new_board[nr2][nc2]==0:
                next_poses.append(((nr1,nc1),(nr2,nc2)))
                
        return next_poses
            

    while queue:
        cur,cnt = queue.popleft()  
        
        for pos in next_pos(cur):

            if (N,N) in pos:
                return cnt+1
            if pos not in visited:
                visited.add(pos)
                queue.append((pos,cnt+1))
    return 0   
            
    
    
        
    
    