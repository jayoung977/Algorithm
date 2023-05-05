for i in range(1, 11):
    n = int(input())
    cnt = 0
    arr = []
    for j in range(8):
        row = list(input())
        arr.append(row)
        for k in range(8):
            if n+k > 8:
                break
            row_part = row[k:n+k]
            if row_part == row_part[::-1]:
                cnt += 1

    arr_rev = list(map(list, zip(*arr)))
    for r in arr_rev:
        for k in range(8):
            if n+k > 8:
                break
            row_part = r[k:n+k]
            if row_part == row_part[::-1]:
                cnt += 1
    print(f"#{i} {cnt}")
