def solution(n, lost, reserve): 
    lost.sort()
    reserve.sort()
    answer = n-len(lost)
    for l in lost:
        if l in reserve:
            answer+=1
            reserve.remove(l)
        elif l-1 in reserve:
            answer+=1
            reserve.remove(l-1)
            # continue
        elif l+1 in reserve and l+1 not in lost:
            answer+=1
            reserve.remove(l+1)
            # continue
        # print(reserve)
            
    return answer