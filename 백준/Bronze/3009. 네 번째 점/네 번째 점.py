x1,y1 =  map(int,input().split())
x2,y2 =  map(int,input().split())
x3,y3 =  map(int,input().split())

xs = [x1,x2,x3]
ys = [y1,y2,y3]

x = [ x for x in xs if xs.count(x) == 1][0]
y = [ y for y in ys if ys.count(y) == 1][0]
print(x, y)