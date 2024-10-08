from collections import deque
def solution(begin, target, words):
    q = deque([(begin,0)])
    visited = set()
    visited.add(begin)
    answer = 0
    while q:
        w,cnt=q.popleft()
        if w == target:
            answer = cnt
            break
        for nw in words:
            if nw in visited:
                continue
            not_eq = 0
            for idx, nww in enumerate(nw):
                if w[idx]!=nww:
                    not_eq+=1
                if not_eq>1:
                    break
            if not_eq==1:
                visited.add(nw)
                q.append((nw,cnt+1))
            
    return answer