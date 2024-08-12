
def solution(sizes):
    sizes = [ [y,x] if x < y else [x,y] for x,y in sizes ]

    max_row = 0
    max_col = 0
    for x,y in sizes:
        max_row = max(max_row,x)
        max_col = max(max_col,y)
            
    answer = max_row*max_col
    return answer