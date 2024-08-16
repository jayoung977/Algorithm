answer = 0
temp=""
def dfs(numbers,target):
    global temp,answer
    if len(temp)==len(numbers):
        summary = 0
        for op,n in zip(temp,numbers):
            if op=="+":
                summary+=n
            else:
                summary-=n
        if summary==target:
            answer+=1
                
        # print(temp)
        return
    for i in ["+","-"]:
        temp+=i
        dfs(numbers,target)
        temp=temp[:-1]
    return
         
        
def solution(numbers, target):
    dfs(numbers,target)
    return answer