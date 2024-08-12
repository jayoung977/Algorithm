def solution(citations):
    len_cite = len(citations)
    for i in range(len_cite+1,1,-1):
        if len(list(filter(lambda x: x>=i,citations))) >= i:
            return i
    return 0
        
        
