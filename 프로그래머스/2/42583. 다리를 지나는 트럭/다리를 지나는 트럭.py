from collections import deque
def solution(bridge_length, weight, truck_weights):
    trucks = deque(truck_weights)
    bridge = deque() 
    answer = 0
    #초기값 넣는 부분이 안될 수도 있는게 길이가 1이면 다음값 뺼 때 에러남
    total_weight = 0 #sum 대신 이방법이 시간초과 안남

    while trucks:
        next_truck = trucks[0]
        if next_truck + total_weight <= weight and len(bridge) < bridge_length:
            current_truck = trucks.popleft()
            total_weight += current_truck
            bridge.append(current_truck)
        else:
            bridge.append(0)
        answer+=1
        
        if len(bridge) == bridge_length:
            total_weight -= bridge.popleft()
            
    answer+=bridge_length #이부분 놓쳤었음
    
    return answer
