def solution(s):
    stack = []
    for item in s:
        if not stack and item==")":
            return False
        if stack and stack[-1]!=item:
            stack.pop()
            continue
        stack.append(item)
    if stack:
        return False

    return True