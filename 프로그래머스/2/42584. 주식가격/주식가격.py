from collections import deque
def solution(prices):
    price_que = deque(prices)    
    answer = [0]*len(prices)
    cnt = 0
    while price_que:
        current_price = price_que.popleft()
        for next_price in price_que:
            answer[cnt]+=1
            if next_price < current_price:
                break
            # else:
                
        cnt+=1
        
    return answer