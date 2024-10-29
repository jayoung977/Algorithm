from itertools import permutations
def isPrime(num):
    if num<2:
        return False
    for i in range(2,int(num**(1/2))+1):
        if num%i==0:
            return False
    return True

def solution(numbers):
    answer = 0
    li = list(numbers)
    visited = set()
    for n in range(1,len(li)+1):
        for perm in permutations(li,n):
            num = ""
            for p in perm:
                num+=p
            num = int(num)   
            if num in visited:
                continue
            visited.add(num)
            
            if isPrime(num):
                answer+=1
    return answer