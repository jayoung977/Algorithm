# 첫 번째 행과 열을 모두 1로 초기화하면안됨. 웅덩이가 있을 경우 이 부분도 고려해야 합니다.
def solution(m, n, puddles):
    dp = [ [0]*(m+1) for i in range(n+1)]
    dp[1][1]=1     
    for i in range(1,n+1):
        for j in range(1,m+1):
            if i==1 and j==1:
                continue
            if [j,i] in puddles:
                continue
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007
    return dp[n][m]