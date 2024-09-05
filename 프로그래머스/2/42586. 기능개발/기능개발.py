from math import ceil
def solution(progresses, speeds):
    stack = []
    answer = []
    cnt = 0
    for p,s in zip(progresses,speeds):
        cost = ceil((100-p)/s)
        if stack:
            if stack[-1]>=cost:
                answer[cnt]+=1
            else:
                stack.pop()
                cnt+=1
                answer.append(1)
                stack.append(cost)
                
        else:
            answer.append(1)
            stack.append(cost)
            
    
    return answer