from heapq import heappop,heappush
def solution(n, k, enemy):
    hq=[] 
    defence=0
    delete=0
    answer = 0

    for i in range(len(enemy)):
        defence += enemy[i]
        heappush(hq, -enemy[i])  # 인덱스는 필요 없으므로 enemy[i]만 삽입
        # print("i:{},delete:{},defence:{},hq:{}".format(i,delete,defence,hq))
        # defence가 n 이상일 경우 방어할 수 없으므로 병력 소모를 통해 조정
        while defence > n and delete < k:
            defence -= -heappop(hq)  # 가장 작은 적의 병력을 제거
            delete += 1
            # print("--delete:{},defence:{},hq:{}".format(delete,defence,hq))
            
        

        # 방어 불가능하면 종료
        if defence > n and delete==k:
            break
        else:
            answer = i + 1  # 성공한 라운드 수를 기록
            # print("answer:{}".format(answer))
            

    return answer