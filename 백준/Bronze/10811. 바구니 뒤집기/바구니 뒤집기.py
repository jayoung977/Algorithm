n,m = map(int, input().split())
basket = [i+1 for i in range(n)]
i = 0
while(i < m):
    fn, ln = map(int, input().split())
    basket = basket[:fn-1] + basket[fn-1:ln][::-1]+ basket[ln:]
    i+=1
print(*basket)