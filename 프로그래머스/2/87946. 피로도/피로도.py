from itertools import permutations
def solution(k, dungeons):
    answer = 0
    for p in permutations(dungeons,len(dungeons)):
        life = k
        result = 0
        for least_p,need_p in p:
            if life >= least_p:
                life-=need_p
                result+=1
        answer = max(result,answer)
    return answer