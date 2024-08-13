temp, answer = "",0
visited = []
flag=False
def dfs(word):
    global temp,answer,flag
    if temp==word:
        flag=True
        return
    if len(temp) == 5:
        return
    for w in ["A","E","I","O","U"]:
        temp+=w
        if temp not in visited:
            visited.append(temp)
            answer+=1
            dfs(word)
            if flag:
                return
            temp = temp[:-1]
            
    return
    
    
def solution(word):
    dfs(word)
    
    return answer