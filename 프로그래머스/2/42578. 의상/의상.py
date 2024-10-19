def solution(clothes):
    dic = {}
    for cloth,kind in clothes:
        if kind in dic:
            dic[kind]+=[cloth]
            continue         
        dic[kind]=[cloth]

    answer = 1
    for kind in dic:
        answer*=(len(dic[kind])+1)
    return answer-1