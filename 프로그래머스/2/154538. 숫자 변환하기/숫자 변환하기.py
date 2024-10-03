from collections import deque
def solution(x, y, n):   
    answer = 1e9
    q = deque()
    q.append((x,0))
    visited = set()
    visited.add(x)
    while q:
        num,cnt=q.popleft()
        if num==y:
            answer=cnt
            break
        if num+n<=y and num+n not in visited:
            q.append([num+n,cnt+1])
            visited.add(num+n)
        if num*2<=y and num*2 not in visited:
            q.append([num*2,cnt+1])
            visited.add(num*2)
        if num*3<=y and num*3 not in visited:
            q.append([num*3,cnt+1])
            visited.add(num*3)
    
    if answer == 1e9:
        answer=-1
        
    
    return answer