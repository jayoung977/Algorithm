def solution(routes):
    routes.sort(key=lambda x:(x[1],x[0]))
    stack=[]
    answer = 0
    for s,e in routes:
        if stack and stack[-1]>=s:
            continue
        stack.append(e)
            
    return len(stack)