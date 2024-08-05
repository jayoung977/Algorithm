def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    cnt = 0
    for p in participant:
        if cnt < len(completion):
            c = completion[cnt]
            if p == c:
                cnt+=1
            else:
                return p
            
        
        
    return p