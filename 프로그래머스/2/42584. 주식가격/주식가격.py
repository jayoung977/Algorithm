from collections import deque
def solution(prices):
    q = deque([ (p,i) for i,p in enumerate(prices)])
    answer = [0]*len(prices)
    while q:
        p,i = q.popleft()
        for np,ni in q:
            answer[i]+=1
            if p>np:
                break
            
    return answer