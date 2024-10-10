from collections import Counter
def solution(n, lost, reserve):
    answer = n-len(lost)
    lost.sort()
    reserve.sort()
    # 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우, 배열에서 제외
    count = Counter(reserve)+Counter(lost)
    for k,v in count.items():
        if v == 2:
            answer+=1
            lost.remove(k)
            reserve.remove(k)
            
    for r in reserve:
        if r-1 in lost:
            answer+=1
            lost.remove(r-1)
        elif r+1 in lost:
            answer+=1
            lost.remove(r+1)
                
    return answer