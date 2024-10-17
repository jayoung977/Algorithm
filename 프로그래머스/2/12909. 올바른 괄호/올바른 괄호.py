def solution(s):
    if s[0]==")" or len(s)%2!=0:
        return False
    stack = []
    for elem in s:
        if stack and stack[-1]!=elem:
            stack.pop()
            continue
        if elem == ")":
            return False
        stack.append(elem)
    if stack:
        return False

    return True