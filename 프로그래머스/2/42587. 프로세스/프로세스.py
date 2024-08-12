from collections import deque
def solution(priorities, location):
    queue = deque((i,p) for i,p in enumerate(priorities))
    answer = 0
    while queue:
        cur = queue.popleft()
        if any(cur[1] < p for i,p in queue):
            queue.append(cur)
        else:
            answer+=1
            if cur[0]==location:
                return answer
    return answer