import heapq
def cooking(low1, low2):
    return low1 + (low2*2)

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while any(s < K for s in scoville ):
        try:
            low1 = heapq.heappop(scoville)
            low2 = heapq.heappop(scoville)
            new_food = cooking(low1,low2)
            heapq.heappush(scoville,new_food)
            answer+=1
            # print(scoville)
        except:
            return -1
    
    
    return answer
