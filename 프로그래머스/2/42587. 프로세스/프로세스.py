from collections import deque
from heapq import heappush,heappop
def solution(priorities, location):
    q = deque()
    hq = []
    for i,p in enumerate(priorities):
        q.append((p,i))
        heappush(hq,(-p,i))
    answer = []
    while q:
        if q[0][0]!=-hq[0][0]:
            while q[0][0]!=-hq[0][0]:
                cur = q.popleft()
                q.append(cur)
        else:
            # print(q[0])
            cur = q.popleft()
            heappop(hq)
            answer.append(cur[1])
            # print(answer)
            
        
        

    return answer.index(location)+1