def dfs(x,cnt,word):
    global visited,result,answer,flag
    if x == word:
        answer=cnt
        flag=False
        return
    for alpha in ('A', 'E', 'I', 'O', 'U'):
        x += alpha
        if x in visited or len(x)>5:
            continue
        result+=1
        visited.add(x)
        dfs(x,result,word)
        if not flag:
            return
        x =x[:-1]
    return
        
    
    

def solution(word):
    global visited,result,answer,flag
    visited = set()
    answer = 0
    result = 0
    flag = True
    dfs("",result,word)
    return answer