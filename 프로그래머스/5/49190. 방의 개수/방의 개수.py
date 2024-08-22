def solution(arrows):
    dr = [0,1,1,1,0,-1,-1,-1]
    dc = [-1,-1,0,1,1,1,0,-1]
    
    r,c = 0,0
    visited_node = set()
    visited_node.add((r,c))
    route = set()
    answer = 0
    for arrow in arrows:
        for _ in range(2):
            nr,nc = r+dr[arrow],c+dc[arrow]
            if (nr,nc) in visited_node and (r,c,nr,nc) not in route:
                answer+=1
            route.add((r,c,nr,nc))
            route.add((nr,nc,r,c))
            visited_node.add((nr,nc))
            r,c = nr,nc
    return answer