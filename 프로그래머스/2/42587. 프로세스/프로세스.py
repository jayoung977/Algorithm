from collections import deque
def solution(priorities, location):
    q = deque()
    for i,p in enumerate(priorities):
        q.append((p,i))
    priorities.sort() 
    
    answer = 0
    while q:
        p,i =q.popleft()
        if p!=priorities[-1]:
            q.append((p,i))
        else:
            answer+=1
            if i == location:
                return answer
            priorities.pop()
            

    
    return answer