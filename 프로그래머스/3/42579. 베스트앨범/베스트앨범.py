from collections import deque
def solution(genres, plays):
    li = []
    dic = {}
    for i,(g,p) in enumerate(zip(genres, plays)):
        if g in dic:
            dic[g]+=p
        else:
            dic[g]=p
    for i,(g,p) in enumerate(zip(genres, plays)):
        li.append((-dic[g],g,-p,i))
    li.sort()
    q = deque(li)
    
    cnt=2
    nowg = li[0][1]
    answer = []
    while q:
        now = q.popleft()
        if now[1]!=nowg:
            nowg=now[1]
            cnt=2
            
        if cnt >0:
            answer.append(now[-1])
            cnt-=1
        
            
        
        
        
    
    
            
        
        
        
    
    return answer