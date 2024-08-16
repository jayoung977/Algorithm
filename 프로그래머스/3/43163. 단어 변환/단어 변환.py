from collections import Counter,deque
def solution(begin, target, words):
    answer = 0
    queue = deque()
    queue.append((begin,0))
    visited = []
    visited.append(begin)
    if target not in words:
        return 0
    while queue:
        cur,cnt = queue.popleft()
        for w in words:
            if len(Counter(cur)-Counter(w))==1 and w not in visited:
                if w == target:
                    return cnt+1
                visited.append(w)
                queue.append((w,cnt+1))
                
    return answer