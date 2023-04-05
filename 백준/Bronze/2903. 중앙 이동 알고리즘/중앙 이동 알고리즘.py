f = [0 for i in range(16)]
f[0] = 4

n = int(input())
for i in range(n+1):
    if i > 0:
        f[i] = int((2*(f[i-1])**0.5 -1)**2)
        
print(f[n])