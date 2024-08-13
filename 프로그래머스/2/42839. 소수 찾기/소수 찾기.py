from itertools import permutations
def isPrime(num):
    if num <=1:
        return False
    for i in range(2,int(num**(1/2))+1):
        if num%i==0:
            return False
    return True

def solution(numbers):
    number_list = list(numbers)
    r = 0
    primes = []
    while r <= len(numbers):
        r+=1
        for p in permutations(number_list,r):
            new_num = int(''.join(p))
            if new_num not in primes and isPrime(new_num) :
                primes.append(new_num)
                
    return len(primes)