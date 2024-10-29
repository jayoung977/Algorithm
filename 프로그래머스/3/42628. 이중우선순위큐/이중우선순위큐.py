from heapq import heappush,heappop
def solution(operations):
    min_hq = []
    max_hq = []
    answer = []

    for s in operations:
        op,n = s.split(" ")
        n = int(n)
        
        if op == "I":
            heappush(min_hq,n)
            heappush(max_hq,-n)
            
        elif max_hq and op == "D":
            if n == 1:
                min_hq.remove(-heappop(max_hq))
            else:
                max_hq.remove(-heappop(min_hq))
        # print(min_hq,max_hq)
        
    if not max_hq and not min_hq:
        return [0,0]
    
    return [-heappop(max_hq),heappop(min_hq)]