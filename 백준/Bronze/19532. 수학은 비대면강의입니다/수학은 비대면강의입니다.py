a, b, c, d, e, f = map(int, input().split())

x  = int((e*c-b*f) / (a*e -b*d))
y = int((-d*c+a*f) / (a*e -b*d))

print(x,y)