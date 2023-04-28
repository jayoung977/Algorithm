N, M = map(int, input().split())

house_li = []
chicken_li = []
for i in range(0,N):
    each_row = list(map(int, input().split()))
    for j in range(len(each_row)):
        if each_row[j] == 1:
            house_li.append([i,j])
        elif each_row[j] == 2:
            chicken_li.append([i,j])
# print(chicken_li)
distance_li = []
same_M_dist = 0
for house_r, house_c in house_li:
    house_per_distance = []
    for chicken_r, chicken_c in chicken_li:
        distance = abs(house_r - chicken_r) + abs(house_c- chicken_c) 
        house_per_distance.append(distance)
    same_M_dist += min(house_per_distance)
    distance_li.append(house_per_distance)

# print(distance_li)

def comb(arr, n):
    result = []
    if n > len(arr):
        return result

    if n == 1:
        for i in arr:
            result.append([i])
            
    elif n > 1:
        for i in range(len(arr) - n + 1):
            for j in comb(arr[i + 1:], n - 1):
                result.append([arr[i]] + j)

    return result
    
    


distance_li_reverse = list(map(list,zip(*distance_li)))
# print( comb(distance_li_reverse,2))
combinations = comb(distance_li_reverse,M)

result = 1e9
for c in combinations:
    # print(c)
    distance_li = list(map(list,zip(*c)))
    # print(distance_li)
    result = min( result,sum([ min(li) for li in distance_li]))
print(result)
