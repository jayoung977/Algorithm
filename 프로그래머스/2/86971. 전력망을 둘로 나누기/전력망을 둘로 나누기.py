from collections import deque
def solution(n, wires):
    graph = [[] for _ in range(n+1)]
    for s,e in wires:
        graph[s].append(e)
        graph[e].append(s)
        
    answer = n
    for s,e in wires:
        graph[s].remove(e)
        graph[e].remove(s)
        
        q = deque([(1,1)])
        visited=set([1,])
        while q:
            v,cnt = q.popleft()
            wire_part=cnt
            for nv in graph[v]:
                if nv in visited:
                    continue
                visited.add(nv)
                q.append((nv,cnt+1))
        result = abs(n-(len(visited)*2))
        answer=min(result,answer)
        
        graph[s].append(e)
        graph[e].append(s)

    
    return answer