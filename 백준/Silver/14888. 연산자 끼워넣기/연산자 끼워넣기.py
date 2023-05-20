import sys
n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))


min_result = 1e9
max_result = -1e9

from itertools import permutations
op_list = list(map(int,sys.stdin.readline().split()))
op = []
for i in range(len(op_list)):
    for j in range(op_list[i]):
        op.append(i)
for case in permutations(op,n-1):
    result = data[0]
    for i in range(1,len(data)):
        if case[i-1] == 0:
            result += data[i]
        if case[i-1] == 1:
            result -= data[i]
        if case[i-1] == 2:
            result *= data[i]
        if case[i-1] == 3:
            result /= data[i]
            result = int(result)

    min_result = min(min_result, result)
    max_result = max(max_result, result)


print(max_result)
print(min_result)