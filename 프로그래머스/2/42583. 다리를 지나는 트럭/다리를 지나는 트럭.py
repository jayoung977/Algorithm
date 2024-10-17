from collections import deque
def solution(bridge_length, weight, truck_weights):
    bridge= deque([0]*bridge_length)
    trucks = deque(truck_weights)
    answer = 0
    bridge_w = 0
    while trucks:
        # print("bridge:{},trucks:{}".format(bridge,trucks))
        bridge_w -= bridge.popleft()
        answer+=1 #시간 +1
        if bridge_w+trucks[0]<=weight:
            truck_w = trucks.popleft()
            bridge_w += truck_w
            bridge.append(truck_w)
            continue
        bridge.append(0)

        
        
    return answer+bridge_length