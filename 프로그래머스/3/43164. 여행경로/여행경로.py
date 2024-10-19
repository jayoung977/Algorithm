def solution(tickets):
    def dfs(airport,visited,path):
        # print(airport,visited,path)
        if len(visited)==len(tickets):
            answer.append(path)
            return
            
        for i,(s,e) in enumerate(tickets):
            if s == airport and i not in visited:
                dfs(e,visited+[i],path+[e])
        return
                
        
        
    
    answer = []
    dfs("ICN",[],["ICN"])
    answer.sort()
    return answer[0]