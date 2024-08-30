def dfs(total,op_list,depth,num_list):
    global max_ans,min_ans
    if depth == len(num_list)-1:
        max_ans = max(total,max_ans)
        min_ans = min(total,min_ans)
        return
    
    for i in range(len(op_list)):
        if op_list[i]<=0:
            continue

        op_list[i]-=1

        if i == 0:
            dfs(total+num_list[depth+1],op_list,depth+1,num_list)
            
        elif i == 1:
            dfs(total-num_list[depth+1],op_list,depth+1,num_list)
        elif i == 2:
            dfs(total*num_list[depth+1],op_list,depth+1,num_list)
        else:
            if total<0:
                dfs(((-1*total)//num_list[depth+1])*-1,op_list,depth+1,num_list)
            else: 
                dfs(total//num_list[depth+1],op_list,depth+1,num_list)
        op_list[i]+=1
    return 
            



N = int(input())
num_list = list(map(int,input().split()))
op_list = list(map(int,input().split()))
max_ans,min_ans = -1e9,1e9
dfs(num_list[0],op_list,0,num_list)
print(max_ans)
print(min_ans)