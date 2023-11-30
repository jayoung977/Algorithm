from collections import deque
def next_position(cur,new_board):
    next_pos_list = []
    cur = list(cur)
    r_1,c_1,r_2,c_2 = cur[0][0],cur[0][1],cur[1][0],cur[1][1]
    
    dr = [0,1,0,-1]
    dc = [1,0,-1,0]
    #이동 
    for d in range(4):
        nr_1 = r_1 + dr[d]
        nc_1 = c_1 + dc[d]
        nr_2 = r_2 + dr[d]
        nc_2 = c_2 + dc[d]
        if(new_board[nr_1][nc_1]==0 and new_board[nr_2][nc_2]==0):
            next_pos_list.append({(nr_1,nc_1),(nr_2,nc_2)})
    #회전        
    #가로 방향이면
    if(r_1 == r_2):
        for i in [-1,1]:
            # 위칸 혹은 아래칸이 비어있어야함
            if(new_board[r_1+i][c_1]==0 and new_board[r_2+i][c_2]==0):
                next_pos_list.append({(r_1,c_1),(r_1+i,c_1)})
                next_pos_list.append({(r_2,c_2),(r_2+i,c_2)})
        return next_pos_list
    #세로 방향이면
    for i in [-1,1]:
        # 위칸 혹은 아래칸이 비어있어야함
        if(new_board[r_1][c_1+i]==0 and new_board[r_2][c_2+i]==0):
            next_pos_list.append({(r_1,c_1),(r_1,c_1+i)})
            next_pos_list.append({(r_2,c_2),(r_2,c_2+i)})      
    return next_pos_list


def solution(board):

    #외부 벽 1로 두르기 
    n = len(board)
    new_board = [[1]*(n+2) for _ in range(n+2)]
    for i in range(n):
        for j in range(n):
            new_board[i+1][j+1] = board[i][j]
    #bfs 

    q = deque([({(1,1),(1,2)},0)])
    visited = [{(1,1),(1,2)}]
    while q:
        cur,time= q.popleft()
        for pos in next_position(cur,new_board):
            if (n,n) in pos:
                return time+1
            if pos not in visited:
                visited.append(pos)
                q.append((pos,time+1))

    return 0