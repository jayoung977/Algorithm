from itertools import permutations
def solution(numbers):
    def isPrime(number):
        if number in (0,1):
            return False
        
        for i in range(2,int(number**(1/2))+1):
            if i == 1:
                continue
            if number%i==0:
                return False
        return True
    
    li = list(numbers)
    visited = set()
    answer = 0
    for n in range(1,len(li)+1):
        for perm in permutations(li,n):
            number = int("".join(perm))
            if number in visited:
                continue
            visited.add(number)
            if isPrime(number):
                answer+=1
            
    
    return answer