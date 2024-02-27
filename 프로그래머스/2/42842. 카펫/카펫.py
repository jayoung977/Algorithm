def solution(brown, yellow):
    answer = []
    for h in range(1,int(yellow**(1/2))+1):
        w = yellow // h
        if(yellow % h == 0 and (w+h)*2+4 == brown):
            
            print(w+2,h+2)
            answer+=[w+2,h+2]
            
    
    
    return answer