from sys import stdin
input = stdin.readline

n, c = map(int, input().split())
array = [int(input()) for _ in range(n)]
array.sort()

# gap을 이진탐색으로 파라메트릭 서치 함
start =1  # gap 최소
end = array[-1]-array[0]

result = 0
while (start <= end):
    mid = (start + end) // 2
    value = array[0]
    count = 1
    for i in range(1, n):
        if (array[i] >= value+mid):
            value = array[i]
            count += 1
    if (count >= c):
        start = mid+1
        result = mid
    else:
        end = mid-1
print(result)