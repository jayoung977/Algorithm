import heapq
def cal(l1,l2):
    return l1+(l2*2)

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while len(scoville)>1:
        l1 = heapq.heappop(scoville)
        if l1 < K:
            l2 = heapq.heappop(scoville)
            new_food = cal(l1,l2)
            heapq.heappush(scoville,new_food)
            answer+=1
        else:
            return answer
        
    if heapq.heappop(scoville) >=K:
        return answer
            
    return -1