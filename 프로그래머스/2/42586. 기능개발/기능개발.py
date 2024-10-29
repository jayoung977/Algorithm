from math import ceil
def solution(progresses, speeds):
    stack = []
    answer = []
    for p,s in zip(progresses,speeds):
        day = ceil((100-p)/s)
        if stack and stack[-1]>=day:
            answer[-1]+=1
        else:
            stack.append(day)
            answer.append(1)
            
            
    return answer