from math import ceil
def solution(progresses, speeds):
    answer = []
    stack = []
    for p,s in zip(progresses,speeds):
        days = ceil((100-p)/s)
        if stack and stack[-1]>=days:
            answer[-1]+=1
            continue
        answer.append(1)
        stack.append(days)
    return answer