from collections import deque
def solution(bridge_length, weight, truck_weights):
    bridge = deque([0]*bridge_length)
    trucks = deque(truck_weights)
    bridge_weight = 0
    answer = 0
    while trucks:
        bridge_weight-=bridge.popleft()
        if trucks[0]+bridge_weight<=weight:
            truck_weight = trucks.popleft()
            bridge.append(truck_weight)
            bridge_weight+=truck_weight
        else:
            bridge.append(0)
            
        answer+=1
           
    return answer+bridge_length