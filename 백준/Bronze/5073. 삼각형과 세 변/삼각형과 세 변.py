
while(True):
    a, b, c = map(int,input().split())
    if a == 0 and b == 0 and c == 0:
        break
    li = [a,b,c]
    count = [li.count(num) for num in li ]

    if max(li) < (sum(li)-max(li)):
        if max(count) == 3:
            print('Equilateral')
        elif max(count) == 2:
            print('Isosceles')
        elif max(count) == 1:
            print('Scalene')
    else:
        print('Invalid')