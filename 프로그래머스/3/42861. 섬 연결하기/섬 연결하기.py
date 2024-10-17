def solution(n, costs):
    def find_parent(x):
        if parent[x]!=x:
            parent[x]=find_parent(parent[x])
        return parent[x]
    
    def union(a,b):
        a = find_parent(a)
        b = find_parent(b)
        if a < b:
            parent[b]=a
        else:
            parent[a]=b
        return
    
    parent = [ i for i in range(n)]
    costs.sort(key=lambda x:x[2])
    answer = 0
    for s,e,cost in costs:
        if find_parent(s)!=find_parent(e):
            union(s,e)
            answer+=cost
            
        
    # print(costs)
            
            
    
    return answer