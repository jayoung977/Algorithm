def find(x):
    if (parent[x] != x):
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if (a == b):
        return False
    if (a < b):
        parent[b] = a
    else:
        parent[a] = b
    return True


v, e = map(int, input().split())
parent = [0]*(v+1)

result = []
edges = []

for i in range(1, v+1):
    parent[i] = i

for _ in range(e):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))

edges.sort()

for e in edges:
    c, a, b = e
    if (union(a, b)):
        result.append(c)

result.remove(max(result))
print(sum(result))