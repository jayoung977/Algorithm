m, n = map(int, input().split())

input_arr = []
for i in range(m):
    row = list(input().strip())
    input_arr.append(row)


arr_1 = [ 
    ['W','B','W','B','W','B','W','B'],
    ['B','W','B','W','B','W','B','W'],
    ['W','B','W','B','W','B','W','B'],
    ['B','W','B','W','B','W','B','W'],
    ['W','B','W','B','W','B','W','B'],
    ['B','W','B','W','B','W','B','W'],
    ['W','B','W','B','W','B','W','B'],
    ['B','W','B','W','B','W','B','W'],
]

arr_2 = [ 
    ['B','W','B','W','B','W','B','W'],
    ['W','B','W','B','W','B','W','B'],
    ['B','W','B','W','B','W','B','W'],
    ['W','B','W','B','W','B','W','B'],
    ['B','W','B','W','B','W','B','W'],
    ['W','B','W','B','W','B','W','B'],
    ['B','W','B','W','B','W','B','W'],
    ['W','B','W','B','W','B','W','B'],
]

sum_1_li =[]
sum_2_li = []
for i in range(m-8+1): #행
    for j in range(n-8+1): #열
        sum_1 = 0
        sum_2 = 0
        for k in range(0,8):
            for l in range(0,8):
                if input_arr[i+k][j+l] != arr_1[k][l]:
                    sum_1 +=1
                if input_arr[i+k][j+l] != arr_2[k][l]:
                    sum_2 +=1   
        sum_1_li.append(sum_1)   
        sum_2_li.append(sum_2)   
print(min([min(sum_1_li),min(sum_2_li)])) 