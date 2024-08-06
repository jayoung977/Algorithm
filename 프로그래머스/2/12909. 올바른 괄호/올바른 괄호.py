from collections import deque
def solution(s):
    q = deque()
    for i in s:
        if i == "(":
            q.append("(")
        else:
            try:
                q.pop()
            except:
                return False
    return len(q)==0