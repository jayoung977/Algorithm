def solution(plans):
    def convert_time(str):
        h,m = map(int,str.split(":"))
        return h*60+m
    
    answer = []
    for i in range(len(plans)):
        plans[i][1]=convert_time(plans[i][1])
        plans[i][2]=int(plans[i][2])
    plans.sort(key=lambda x:x[1])
    
    stack = []
    for i in range(len(plans)-1):
        gap = plans[i+1][1]-plans[i][1]
        stack.append([plans[i][0],plans[i][2]])
        while stack and gap:
            if stack[-1][1]<=gap:
                gap-=stack[-1][1]
                answer.append(stack[-1][0])
                stack.pop()
            else:
                stack[-1][1]-=gap
                gap=0
    answer.append(plans[-1][0])
    for i in range(len(stack)):
        answer.append(stack[~i][0])
    
                
        
    return answer