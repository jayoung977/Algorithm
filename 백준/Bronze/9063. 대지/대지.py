n =  int(input())

i = 0
x_li = []
y_li = []

while(i < n):
    x,y = map(int,input().split())
    x_li.append(x)
    y_li.append(y)
    i+=1
if n > 1:
    area = (max(x_li) - min(x_li))*(max(y_li) - min(y_li))
    print(area)
else:
    print(0)