def dfs(n,graph,s,visited):
    visited[s] = True
    for e in graph[s]:
        if visited[e]==False:
            dfs(n,graph,e,visited)


def solution(n, wires):
    graph_list = []
    s_list = []
    for i in range(len(wires)):
        new_wires = wires.copy()
        new_wires.remove(wires[i])
        # print("new_wires:",new_wires)
        graph = [[] for i in range(n+1)]
        flag = False
        for node in new_wires:
            s,e = node
            graph[s].append(e)
            graph[e].append(s)
            if flag==False:
                s_list.append(s)
                flag = True
        graph_list.append(graph)
    # print("s_list:",s_list)
    # print("graph_list",len(graph_list))
    answer = 1e9
    for i in range(len(graph_list)):
        graph = graph_list[i]
        s = s_list[i]
        visited = [False]*(n+1) 
        dfs(n,graph,s,visited)
        result = abs(visited[1:].count(False)-visited[1:].count(True))
        answer = min(result,answer)        
    return answer