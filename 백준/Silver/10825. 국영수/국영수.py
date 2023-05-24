n = int(input())
li = []
for i in range(n):
    name, korea, english, math = input().split()
    korea, english, math = int(korea), int(english), int(math)
    li.append([name, korea, english, math])

li.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))
for i in li:
    print(i[0])