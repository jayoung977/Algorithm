def cal(word):
    return min(ord(word)-ord("A"), ord("Z")-ord(word)+1)

def solution(name):
    answer = 0
    min_cursor = len(name)-1
    for i,word in enumerate(name):
        answer+=cal(word)
        next = i+1
        while next<len(name) and name[next]=="A":
                next+=1
        min_cursor = min([min_cursor,2*i+(len(name)-next),2*(len(name)-next)+i])
    return answer + min_cursor