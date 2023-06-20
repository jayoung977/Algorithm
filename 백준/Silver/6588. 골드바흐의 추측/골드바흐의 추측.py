import sys

prime = []
primeCheck = [0] * 1000001

for i in range(2, 1000001):
    if primeCheck[i] == 0:
        prime.append(i)
        for j in range(2*i, 1000001, i):
            primeCheck[j] = 1

while True:
    n = int(sys.stdin.readline())
    if n == 0: break
    for i in range(1, len(prime)):
        if primeCheck[n - prime[i]] == 0:
            print(f'{n} = {prime[i]} + {n - prime[i]}')
            break