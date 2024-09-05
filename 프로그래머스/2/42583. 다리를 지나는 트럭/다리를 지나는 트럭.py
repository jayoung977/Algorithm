from collections import deque
def solution(bridge_length, weight, truck_weights):
    q = deque([ 0 for _ in range(bridge_length)])
    
    trucks = deque([ truck for truck in truck_weights])
    answer = 0
    total = 0
    while trucks:
        cur_truck = q.popleft()
        total-= cur_truck
        if total + trucks[0]<=weight:
            next_truck = trucks.popleft()
            q.append(next_truck)
            total+=next_truck
        else:
            q.append(0)
            
        answer+=1
    
    
    return answer+bridge_length