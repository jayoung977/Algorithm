def solution(phone_book):
    phone_book.sort()
    stack = []
    for p in phone_book:
        if stack and p.startswith(stack[-1]):
            return False
        stack.append(p)
    return True