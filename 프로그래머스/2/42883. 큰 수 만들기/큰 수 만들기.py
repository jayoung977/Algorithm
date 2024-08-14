def solution(number, k):
    stack = []
    for i, num in enumerate(number):
        # 스택의 마지막 숫자가 현재 숫자보다 작으면 제거
        while stack and k > 0 and stack[-1] < num:
            stack.pop()
            k -= 1
        stack.append(num)
    
    # 만약 제거할 숫자가 남아있다면 뒤에서부터 제거
    if k > 0:
        stack = stack[:-k]
    
    return ''.join(stack)