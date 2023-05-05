for i in range(1,11):
    n = int(input())
    arr = []
    row_max = 0
    sum_lcross = 0
    sum_rcross = 0
    for j in range(100):
        row = list(map(int, input().split()))
        row_max = max(row_max, sum(row))
        sum_lcross += row[j]
        sum_rcross += row[-(j+1)]
        arr.append(row)
    arr_reverse = list(map(list, zip(*arr)))
    row_reverse_max = 0
    for li in arr_reverse:
        row_reverse_max = max(row_reverse_max, sum(li))
    answer = max(row_max, sum_lcross, sum_rcross, row_reverse_max)
    print(f"#{i} {answer}")