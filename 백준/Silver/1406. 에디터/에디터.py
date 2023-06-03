import sys

s1 = list(sys.stdin.readline().strip())
s2 = []
m = int(sys.stdin.readline())
n = len(s1)

for i in range(m):
    com = sys.stdin.readline().strip()
    if com[0] == "P":
        s1.append(com[2])  # 첫번째 스택에 추가
    elif com[0] == "L" and s1 != []:
        s2.append(s1.pop())  # 커서가 왼쪽으로 간다는 건 첫 스택에서 pop한거를 두번쨰로 옮겨줌
    elif com[0] == "D" and s2 != []:
        s1.append(s2.pop())  # 커서가 오른쪽으로 간다는건 두번쨰 스택에서 pop한거를 첫번째로 옮겨줌
    elif com[0] == "B" and s1 != []:
        s1.pop()
print("".join(s1 + list(reversed(s2))))