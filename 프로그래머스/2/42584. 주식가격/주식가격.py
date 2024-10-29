from collections import deque
def solution(prices):
    answer = []
    q = deque(prices)
    idx = 0
    while q:
        now = q.popleft()
        answer.append(0)
        for nex in q:
            answer[-1]+=1
            if nex < now:
                break
            
    return answer