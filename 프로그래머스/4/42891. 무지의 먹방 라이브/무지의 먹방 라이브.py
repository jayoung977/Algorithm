import heapq
def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    food_times = [ (x,i+1) for i,x in enumerate(food_times) ]
    heapq.heapify(food_times)
    
    ex_food = 0
    while food_times and  k - (food_times[0][0]-ex_food)*len(food_times)>0:
        k-=(food_times[0][0]-ex_food)*len(food_times)
        ex_food=food_times[0][0]
        heapq.heappop(food_times)
        
    if not food_times:
        return -1
    
    result = sorted(food_times,key=lambda x:x[1])
    return result[k%len(food_times)][1]