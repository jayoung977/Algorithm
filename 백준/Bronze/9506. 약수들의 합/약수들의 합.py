while(True):
    n =  int(input())
    if n == -1:
        break
    sum = 0
    li = []
    for i in range(n-1): #자기자신 제외
        i = i+1  
        if n%i == 0:
            sum+=i
            li.append(i)
            
    if sum == n:
        print(f"{n} = {(' + ').join(map(str,li))}")
    else:
        print(f"{n} is NOT perfect.")