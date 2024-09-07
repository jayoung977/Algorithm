from collections import deque
import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N, K = map(int, input().split())
    cost = list(map(int, input().split()))  
    G = [[] for _ in range(N+1)] 
    indegree = [0] * (N+1) 

    for _ in range(K):
        a, b = map(int, input().split())
        G[a].append(b)
        indegree[b] += 1
    
    X = int(input())  
    dp = [0] * (N+1)

    q = deque()
    

    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
            dp[i] = cost[i-1]  
    
    while q:
        v = q.popleft()
        
        for nv in G[v]:
            indegree[nv] -= 1
            dp[nv] = max(dp[nv], dp[v] + cost[nv-1])
            
            if indegree[nv] == 0:
                q.append(nv)
    
    print(dp[X])