for i in range(1, 11):
    dump = int(input())
    li = list(map(int, input().split()))

    for j in range(dump):
        li.sort()
        li[-1] -= 1
        li[0] += 1
    answer = max(li) - min(li)
    print(f"#{i} {answer}")