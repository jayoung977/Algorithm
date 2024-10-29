def solution(numbers, target):
    def dfs(depth,num):
        if depth == len(numbers):
            if num == target:
                answer[0]+=1
            return
        dfs(depth+1,num+numbers[depth])
        dfs(depth+1,num-numbers[depth])
        return
        
    answer = [0]
    dfs(0,0)
    return answer[0]