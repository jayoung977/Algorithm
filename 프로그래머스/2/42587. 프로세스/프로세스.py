from collections import deque
def solution(priorities, location):
    q = deque()
    for i,p in enumerate(priorities):
        q.append((p,i))
    priorities.sort(reverse=True)
    max_p = priorities[0]
    idx = 0
    while q:
        p,i = q.popleft()
        if p!=max_p:
            q.append((p,i))
            continue
        #같으면 
        if i == location:
            return idx+1
        idx+=1
        max_p = priorities[idx]
        
    return answer