from collections import deque
import sys

# n,m,k,x = map(int, input().split())
n,m,k,x = map(int, sys.stdin.readline().split())

# print(n,m,k,x )
graph=[[] for _ in range(n+1)]
# print(graph)
for _ in range(m):
    # a, b = map(int, input().split())
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)

# print(graph)
visited = [-1]*(n+1)
visited[x] = 0
queue = deque([x])

while queue:
    now = queue.popleft()
    # print('now:',now)
    for i in graph[now]:
        if visited[i] == -1:
            visited[i] = visited[now] + 1
            queue.append(i)
            # print('i:',i)
            # print('visited: ',visited)
            # print('queue:',queue)
check = False
for i in range(1,n+1):
    if visited[i] == k:
        print(i)
        check = True
if check == False:
    print(-1)




