def solution(game_board, table):
    
    m = len(game_board)
    n = len(game_board[0])

    dr = [-1,0,1,0]
    dc = [0,1,0,-1]
    
    def dfs(board,r,c,state,path,visited):
        for d in range(4):
            nr,nc = r+dr[d],c+dc[d]
            # print("nr:{},nc:{}".format(nr,nc))
            if not(0<=nr<m and 0<=nc<n):
                continue
            if visited[nr][nc]==0 and board[nr][nc]==state:
                visited[nr][nc]=1
                path.append((nr,nc))
                dfs(board,nr,nc,state,path,visited)

    def find_blocks(board,state):
        visited = [ [0]*n for _ in range(m)]
        result = [] 
        result_table = []
        for i in range(m):
            for j in range(n):
                if visited[i][j]==0 and board[i][j]==state:
                    visited[i][j] = 1
                    path = [(i,j)]
                    dfs(board,i,j,state,path,visited)
                    result.append(path)
        # print("r:{},c:{},path:{}".format(r,c,path))
        return result
    
    def make_table(block):
        y,x = zip(*block)
        r,c = max(y)-min(y)+1,max(x)-min(x)+1
        table = [[0]*c for _ in range(r)]
        
        for i,j in block:
            table[i-min(y)][j-min(x)]=1
        return table

    def rotate(puzzle):
        c = len(puzzle[0])
        r = len(puzzle)
        count = 0
        rotate = [[0]*r for _ in range(c)]
        for i in range(r):
            for j in range(c):
                if puzzle[i][j]==1:
                    count+=1
                rotate[j][r-1-i]=puzzle[i][j]
        return rotate,count
    
    empty_blocks = find_blocks(game_board,0)
    puzzles = find_blocks(table,1)
    answer = 0
    for empty in empty_blocks:
        Filled = False
        empty_table = make_table(empty)
        for puzzle_origin in puzzles:
            if Filled:
                break
            puzzle_table = make_table(puzzle_origin)
            for i in range(4):
                puzzle_table, count = rotate(puzzle_table)
                if empty_table==puzzle_table:
                    answer+=count
                    Filled=True
                    puzzles.remove(puzzle_origin)
                    break
        for puzzle_origin in puzzles:
            if Filled:
                break
            puzzle_table = make_table(puzzle_origin)
            for i in range(4):
                puzzle_table, count = rotate(puzzle_table)
                if empty_table==puzzle_table:
                    answer+=count
                    Filled=True
                    puzzles.remove(puzzle_origin)
                    break
    
    return answer