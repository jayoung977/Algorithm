def solution(arr):
    answer = []
    for n in arr:
        if answer and answer[-1]==n:
            continue
        answer.append(n)
    
    return answer