def solution(storey):
    answer = 0
    while storey:
        remainder = storey%10
        #0~4
        if remainder<5:
            answer+=remainder
        #6~9
        elif remainder>5:
            answer+=(10-remainder)
            storey+=10
        else:
            if (storey//10)%10>4:
                storey+=10
            answer+=remainder
        storey//=10
                
            
            
            
        
    
    return answer