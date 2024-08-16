visited = []
def dfs(i,computers):
    visited[i]=True
    for j,is_connect in enumerate(computers[i]):
        if j!=i and is_connect==1 and not visited[j]:
            visited[j]=True
            dfs(j,computers)
    return

def solution(n, computers):
    global visited
    visited = [False]*n
    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(i,computers)
            answer+=1    
    return answer