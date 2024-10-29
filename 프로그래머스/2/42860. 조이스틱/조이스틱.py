def cal(alpha):
    return min(ord(alpha)-ord("A"),ord("Z")-ord(alpha)+1)
def solution(name):
    answer = 0
    for alpha in name:
        answer+=cal(alpha)
    result = len(name)-1
    for i in range(len(name)):
        nex_i = i+1
        while nex_i<len(name) and name[nex_i]=="A":
            nex_i+=1
        if nex_i!= i+1:
            result = min([i*2+(len(name)-nex_i),(len(name)-nex_i)*2+i,result])      
    
    return answer+result