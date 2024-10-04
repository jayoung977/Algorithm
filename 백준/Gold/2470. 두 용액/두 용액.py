N = int(input())
arr = list(map(int,input().split()))
arr.sort()
e = N-1
min_sum = int(1e9)*2
left,right=0,0
for s in range(N):
    while s<e:
        current_sum = arr[s]+arr[e]
        if abs(current_sum)<min_sum:
            left,right=s,e
            min_sum=abs(current_sum)
        if current_sum>0:
            e-=1
        else:
            break

print(arr[left],arr[right])