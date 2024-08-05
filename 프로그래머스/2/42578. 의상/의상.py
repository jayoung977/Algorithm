def solution(clothes):
    d = {}
    for v,k in clothes:
        if k not in d:
            d[k]=2 
        else:
            d[k]+=1
        
    answer = 1
    for v in d.values():
        answer*=v
    return answer-1