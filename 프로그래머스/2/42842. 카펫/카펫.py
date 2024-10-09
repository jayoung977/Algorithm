def solution(brown, yellow):
    answer = []
    for x in range(1,yellow+3):
        # print(((brown+yellow)//x)-2)
        if (((brown+yellow)//x)-2)*(x-2)==yellow:
            answer.extend([(brown+yellow)//x,x])
            break
            
    return answer