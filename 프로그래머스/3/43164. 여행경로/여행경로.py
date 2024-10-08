def solution(tickets):
    def dfs(s,visited,path,answer):
        if len(visited)==len(tickets):
            answer.append(path)
            return
        for i,(ns,ne) in enumerate(tickets):
            if i not in visited and ns == s:
                dfs(ne, visited+[i],path+[ne],answer)
                
        return
    tickets.sort()
    answer = []
    dfs("ICN",[],["ICN"],answer)
    answer.sort()
    return answer[0]