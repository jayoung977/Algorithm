from heapq import heappush,heappop
from collections import deque
def solution(jobs):
    answer = 0
    jobs.sort()
    end = 0
    
    q = deque([(t,s) for s,t in jobs])
    hq = []
    heappush(hq,(q.popleft()))
    while hq:
        t,s = heappop(hq)
        end = max(end+t,s+t)
        answer+=end-s
        cnt = len(q)
        while q and q[0][1]<=end:
            heappush(hq,q.popleft())
        if q and not hq:
            heappush(hq,q.popleft())
                
            

    return answer//len(jobs)