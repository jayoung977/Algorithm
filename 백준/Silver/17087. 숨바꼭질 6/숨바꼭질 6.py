def gcd(a, b):
    while b:
        mod = b
        b = a%b
        a = mod
    return a

n, s = map(int, input().split())
a = list(map(int, input().split()))
dif = list(set(abs(a[i]-s) for i in range(n)))
d = min(dif)
for i in range(len(dif)):
    d = gcd(dif[i], d)
    
print(d)
