from collections import deque
def solution(bridge_length, weight, truck_weights):
    trucks = deque(truck_weights)
    bridge = deque() 
    answer = 0
    total_weight = 0

    while trucks:
        next_truck = trucks[0]
        if next_truck + total_weight <= weight and len(bridge) < bridge_length:
            current_truck = trucks.popleft()
            total_weight += current_truck
            bridge.append(current_truck)
        else:
            bridge.append(0)
        answer+=1
        # print(bridge,trucks,answer)
        
        if len(bridge) == bridge_length:
            total_weight -= bridge.popleft()
            
    answer+=bridge_length
            
        
    
    
    return answer