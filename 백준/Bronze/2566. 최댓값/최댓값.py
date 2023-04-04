max_tuple_idx = 0
max_num = 0
arr = []
for i in range(9):
    tuple = list(map(int,input().split())) 
    arr.append(tuple)
    tuple_max_num = max(tuple)
    if tuple_max_num > max_num:
        max_num = tuple_max_num
        max_tuple_idx = i 

max_column_idx =  arr[max_tuple_idx].index(max_num)
print(max_num)
print(max_tuple_idx+1, max_column_idx+1)