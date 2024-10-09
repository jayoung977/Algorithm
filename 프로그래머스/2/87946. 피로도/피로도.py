from collections import deque
def solution(k, dungeons):
    
    q = deque([(k,[],0)])
    
    answer = 0
    while q:
        k, visited, cnt = q.popleft()
        answer=cnt
        for i,(minimum,need) in enumerate(dungeons):
            if i in visited or k < minimum:
                continue
            q.append((k-need,visited+[i],cnt+1))
        
    return answer