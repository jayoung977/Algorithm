n =int(input())

count = 0
for i in range(n):
    s = list(input())
    part = set(s)
    li = []
    for p in part:
        idxs = []
        for i in range(len(s)):
            if s[i] == p:
                idxs.append(i)
        if len(idxs) == 1:
            li.append(0)
        else:
            for i in range(len(idxs)-1):
                if abs(idxs[i]-idxs[i+1]) != 1:
                    li.append(1)
                else:
                    li.append(0)
    if max(li) == 0:
        count += 1

print(count)

        