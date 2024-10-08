def solution(n, computers):
    def dfs(s,visited,path):
        for e,iscon in enumerate(computers[s]):
            if e==s:
                continue
            if e not in visited and iscon==1:
                visited.add(e)
                path+=[e]
                dfs(e,visited,path)
    answer = 0
    visited = set()
    for s in range(n):
        if s not in visited:
            visited.add(s)
            path=[s]
            dfs(s,visited,path)
            answer+=1
    return answer