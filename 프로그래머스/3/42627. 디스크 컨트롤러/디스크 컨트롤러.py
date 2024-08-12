from collections import deque
import heapq
def solution(jobs):
    jobs.sort()  #시간순
    process = deque([(y,x) for x,y in jobs])
       
    heap = [] 
    heapq.heappush(heap,process.popleft())
    
    now = 0
    total = 0
    while heap:
        duration, start = heapq.heappop(heap) 
        now = max(now+duration,start+duration)
        total += (now-start)
        while len(process)>0 and now>=process[0][1]:
            heapq.heappush(heap,process.popleft()) 
        if len(process)>0 and len(heap)==0 :
            heapq.heappush(heap,process.popleft()) 

    return total//len(jobs)