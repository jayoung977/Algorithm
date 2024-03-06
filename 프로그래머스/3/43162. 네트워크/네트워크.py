def dfs(n,computers,s,visited):
    visited[s]=True
    for e in range(n):
        if computers[s][e]==1 and visited[e]==False:
            dfs(n,computers,e,visited)
    
    
            
def solution(n, computers):
    visited = [False]*n
    answer = 0
    for s in range(n):      
        if visited[s] == False:
            print(s)
            print(visited)
            dfs(n,computers,s,visited)
            answer+=1
                
    return answer




# answer = 0
# def dfs(n,computers,r,c,d,visited):
    
#     for i in range(c+1,n):
#         if computers[c][i]==1:
#             visited[i]=visited[c]
#             dfs(n,computers,c,i,d+1,visited)

# def solution(n, computers):
#     visited = 
#     for i in range(n):
#         for j in range(i+1, n):
#             if computers[i][j]==1 and visited[j]==j:
#                 visited[i],visited[j] = i,i
#                 con = dfs(n,computers,i,j,0,visited)
#                 print(visited)
#         answer = min(answer,len(set(visited)))
                
#     return answer
