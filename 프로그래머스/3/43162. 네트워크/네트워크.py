def solution(n, computers):
    def dfs(num):
        for i,con in enumerate(computers[num]):
            if i == num or i in visited or con == 0:
                continue
            visited.add(i)
            dfs(i)
        return
            
            
            
    answer = 0
    visited = set()
    for i in range(n):
        if i not in visited:
            visited.add(i)
            dfs(i)
            answer+=1
    return answer