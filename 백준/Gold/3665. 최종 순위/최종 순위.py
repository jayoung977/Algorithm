from collections import deque
# 바로 옆자리에 있어야 다른 순위 건드리지 않으면서 변경 가능

for tc in range(int(input())):
    n = int(input())
    indegree = [0]*(n+1)
    graph = [[False]*(n+1) for i in range(n+1)]
    data = list(map(int, input().split()))
    for i in range(n):
        for j in range(i+1, n):
            graph[data[i]][data[j]] = True
            indegree[data[j]] += 1

    m = int(input())
    for _ in range(m):
        a, b = map(int, input().split())
        if graph[a][b]:  # a->b => b->a
            graph[a][b] = False
            graph[b][a] = True
            indegree[a] += 1
            indegree[b] -= 1
        else:
            graph[a][b] = True
            graph[b][a] = False
            indegree[a] -= 1
            indegree[b] += 1

    result = []
    q = deque()
    for i in range(1, n+1):
        if (indegree[i] == 0):
            q.append(i)

    isCertain = True
    isCycle = False

    for i in range(n):
        if len(q) == 0:
            isCycle = True
            break
        if len(q) >= 2:
            isCertain = False
            break
        now = q.popleft()
        result.append(now)

        for j in range(1, n+1):
            if graph[now][j]:
                indegree[j] -= 1
                if indegree[j] == 0:
                    q.append(j)
    if isCycle:
        print("IMPOSSIBLE")
    elif not isCertain:
        print("?")
    else:
        for i in result:
            print(i, end=" ")
        print()