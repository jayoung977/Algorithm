def solution(numbers):
    answer = [-1]*len(numbers)
    stack = []
    stack.append((numbers[0],0))
    for i in range(1,len(numbers)):
        while stack and stack[-1][0] < numbers[i]:
            num,idx =stack.pop()
            answer[idx]=numbers[i]
        stack.append((numbers[i],i))
    # for (num,idx) in stack:
    #     ansewer[idx]=-1
    return answer