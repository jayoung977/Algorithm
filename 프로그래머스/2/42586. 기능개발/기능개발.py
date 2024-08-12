import math
from collections import deque
def solution(progresses, speeds):
    dist_days = deque()
    answer = []
    for p,s in zip(progresses,speeds):
        day = math.ceil((100-p)/s)
        if len(dist_days)==0 or (len(dist_days)>0 and dist_days[-1]<day):
            dist_days.append(day)
            answer.append(1)
        else:
            answer[-1]+=1
            
        
        
    
    return answer