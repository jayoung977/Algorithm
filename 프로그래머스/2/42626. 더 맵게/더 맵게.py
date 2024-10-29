from heapq import heappop,heappush,heapify
def cal(a,b):
    return a+(b*2)

def solution(scoville, K):
    answer = 0
    heapify(scoville)

    while scoville:
        if scoville[0]>=K:
            return answer
        
        if len(scoville)>=2:
            a = heappop(scoville)
            b = heappop(scoville)
            new = cal(a,b)
            answer +=1
            heappush(scoville,new)
        else:
            break
        
    return -1