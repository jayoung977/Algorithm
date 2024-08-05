def solution(participant, completion):
    d = dict()
    sum = 0
    for p in participant:
        d[hash(p)] = p
        sum += hash(p)
    for c in completion:
        sum -= hash(c)
    return d[sum]
