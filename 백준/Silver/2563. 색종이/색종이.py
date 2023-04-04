num = int(input())

max_num = 100
paper_max_num = 10

coord_list = []
for i in range(num):
    min_x,min_y = map(int,input().split())
    coord_list.append([min_x,max_num-1-min_y])

arr = [[0 for i in range(max_num)] for i in range(max_num)]


for coord in coord_list:
    min_x = coord[0]
    min_y = coord[1]    
    for col in range(min_y-paper_max_num+1, min_y+1):
        for row in range(min_x, min_x+paper_max_num):
            arr[col][row] =1
        
total = 0
for i in arr:
    total += sum(i)

print(total)