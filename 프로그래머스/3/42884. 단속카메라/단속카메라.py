from collections import deque
def solution(routes):
    
    routes.sort(key=lambda x:(x[1],x[0]))
    queue = deque(routes)
    answer = 0
    while queue:
        current = queue.popleft()
        answer+=1
        while queue and queue[0][0]<=current[1]<=queue[0][1]:
            
            queue.popleft()
    return answer