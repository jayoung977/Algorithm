from collections import deque
def solution(priorities, location):
    q = deque([(p,i) for i,p in enumerate(priorities)])
    q_sort = sorted(priorities)
    answer = 0
    while q:
        p,i = q.popleft()
        if q_sort[-1]==p:
            q_sort.pop()
            answer+=1
            if i == location:
                return answer
            continue
        q.append((p,i))
    return 