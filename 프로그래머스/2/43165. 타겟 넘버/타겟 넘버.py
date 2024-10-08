def solution(numbers, target):
    def dfs(x,depth,answer):
        if depth==len(numbers)-1:
            if x==target:
                answer[0]+=1
            return 
        dfs(x+numbers[depth+1],depth+1,answer)
        dfs(x-numbers[depth+1],depth+1,answer)
        return 
    
    answer = [0]
    dfs(0,-1,answer)
    return answer[0]