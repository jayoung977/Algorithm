from collections import Counter
def solution(weights):
    answer = 0
    count=Counter(weights)
    for k,v in count.items():
        if v>=2:
            answer+=(v*(v-1))/2
    weights = list(set(weights))
    for w in weights:
        for check in (3/2,4/2,4/3):
            if w*check in weights:
                answer+=count[w]*count[w*check]
    return answer