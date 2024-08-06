from collections import deque
from math import ceil
def solution(progresses, speeds):
    q = deque()
    q.append(0)
    answer = [0]
    idx = 0
    for p,s in zip(progresses,speeds):
        print(q)
        day = ceil((100-p)/s)
        if  day > q[-1] :
            q.append(day)
            answer.append(1)
            idx+=1
        else:
            answer[idx]+=1
        
    
    return answer[1:]