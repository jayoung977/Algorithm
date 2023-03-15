total_basket, total_num = map(int,input().split())
b_list = [ i for i in range(1,total_basket+1)]
i=0
while(i < total_num):
    first,last = map(int,input().split())
    first -= 1 
    last -= 1
    temp = b_list[first]
    b_list[first] = b_list[last]
    b_list[last] = temp
    i+=1
print(*b_list)