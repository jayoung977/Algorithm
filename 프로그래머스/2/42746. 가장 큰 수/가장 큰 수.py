def solution(numbers):
    li = list(map(str,numbers))
    li.sort(key=lambda x :x*3,reverse=True)
    return str(int(''.join(li)))