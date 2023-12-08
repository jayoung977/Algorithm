n = int(input())
data = [[0]*n for _ in range(n)]
dp = [[0]*n for _ in range(n)]

for i in range(n):
    arr = list(map(int, input().split()))
    for j in range(len(arr)):
        data[i][j] = arr[j]

dp[0][0] = data[0][0]

for i in range(1, n):
    for j in range(n):
        if (j == 0):
            dp[i][j] = dp[i-1][j]+data[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1]+data[i][j], dp[i-1][j]+data[i][j])

print(max(dp[-1]))