from heapq import heappop,heappush
def solution(n, k, enemy):
    hq=[] 
    defence=0
    delete=0
    answer = 0

    for i in range(len(enemy)):
        defence += enemy[i]
        heappush(hq, -enemy[i])  
        while defence > n and delete < k:
            defence -= -heappop(hq) 
            delete += 1
        if defence > n and delete==k:
            break
        else:
            answer = i + 1 
    return answer