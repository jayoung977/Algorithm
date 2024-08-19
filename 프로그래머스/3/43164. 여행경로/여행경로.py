from collections import deque
def solution(tickets):
    queue = deque()
    queue.append(( "ICN" ,["ICN"],[]))
    answer= []
    while queue:
        start,path,visited = queue.popleft()
        if len(visited) == len(tickets):
            answer.append(path)
        for idx,(s,e) in enumerate(tickets):
            if s==start and idx not in visited:
                queue.append((e,path+[e],visited+[idx]))
    answer.sort()
    return answer[0]