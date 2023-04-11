a, b, c = map(int,input().split())

li = [a,b,c]
count = [li.count(num) for num in li ]

if max(li) < (sum(li)-max(li)):
    print(sum(li))
else:
    li[li.index(max(li))] = sum(li)-max(li) -1
    print(sum(li))