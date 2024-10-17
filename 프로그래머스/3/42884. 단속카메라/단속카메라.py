def solution(routes):
    routes.sort(key=lambda x: x[1])
    stack = []
    for s,e in routes:
        if stack and stack[-1]>=s:
            continue
        stack.append(e)
    return len(stack)