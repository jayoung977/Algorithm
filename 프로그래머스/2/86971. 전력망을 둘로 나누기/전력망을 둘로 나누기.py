def dfs(num):
    global visited,result,li
    for i in li[num]:
        if not visited[i]:
            visited[i]=True
            result+=1           
            dfs(i)
    return 

def solution(n, wires):
    global visited,result,li
    li = [[] for _ in range(n+1)]
    
    answer = 1e9
    for s,e in wires:
        li[s].append(e)
        li[e].append(s)
        
    for s,e in wires:
        li[s].remove(e)
        li[e].remove(s)
        visited = [False]*(n+1)
        visited[1]=True
        result = 1
        dfs(1)
        answer = min(abs(2*result-n),answer)
        li[s].append(e)
        li[e].append(s)
    return answer