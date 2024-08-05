def solution(nums):
    n = len(nums)//2
    x = len(set(nums))
    if x >= n :
        return n
    return x
