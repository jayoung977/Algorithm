def solution(s):
    stack =[]
    for i in s:
        if stack:
            if stack[-1]!=i:
                stack.pop()
            else:
                stack.append(i)
        else:
            if i == ")":
                return False
            else:
                stack.append(i)
                
    if stack:
        return False
                

    return True