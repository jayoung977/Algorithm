from math import ceil
def solution(progresses, speeds):
    answer = []
    stack = []
    idx = 0
    for i,(p,s) in enumerate(zip(progresses,speeds)):
        day = ceil((100-p)/s)
        # print("stack:{},idx:{},day:{}".format(stack,idx,day))
        if stack and stack[-1]>=day:
            answer[-1]+=1
            continue
        stack.append(day)
        answer.append(1)
        # print("answer:{}".format(answer))
            
        
    return answer