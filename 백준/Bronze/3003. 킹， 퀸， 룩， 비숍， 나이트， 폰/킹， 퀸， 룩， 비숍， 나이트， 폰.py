li = list(map(int,input().split()))
ori = [1,1,2,2,2,8]
new = [ ori[i] - li[i] for i in range(len(li)) ]
new = ' '.join(map(str,new))
print(new)
