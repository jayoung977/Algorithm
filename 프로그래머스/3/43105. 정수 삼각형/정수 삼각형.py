def solution(triangle):
    dp = [[0]*i for i in range(1,len(triangle)+1)]
    dp[0]=triangle[0]
    for i in range(1,len(triangle)):
        for j in range(len(triangle[i])):
            if j-1>=0 and j<len(triangle[i-1]):
                dp[i][j] = max(triangle[i][j]+dp[i-1][j-1], triangle[i][j]+dp[i-1][j])
            elif j-1<0:
                dp[i][j] = triangle[i][j]+dp[i-1][j]
            elif j>=len(triangle[i-1]):
                dp[i][j] = triangle[i][j]+dp[i-1][j-1]
                
    # print(dp)
    # # answer = 0
    return max(dp[-1])