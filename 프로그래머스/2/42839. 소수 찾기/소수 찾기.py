from itertools import permutations
def isPrime(n):
    if n == 0 or n ==1:
        return False
    for i in range(2,int(n**(1/2))+1):
        if(n%i==0):
            return False
    return True

def solution(numbers):
    answer = 0
    li = [ i for i in numbers]
    tot = []
    for r in range(1,len(li)+1):
        combi = permutations(li,r)
        for i in combi:
            p_str = ''.join(i)
            p_int = int(p_str)
            if p_int not in tot:
                tot.append(p_int)
                if(isPrime(p_int)):
                    answer+=1

    
    
    
    return answer