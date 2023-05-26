def solution(N, stages):
    fail_rates = []
    user_length = len(stages)
    for i in range(1,N+1):
        if user_length != 0:
            fail_rate = stages.count(i)/user_length   
            user_length -= stages.count(i)
            fail_rates.append([i,fail_rate])
        else:
            fail_rates.append([i,0])
            
    fail_rates.sort(key= lambda x : (-x[1], x[0]))
    answer = list(map(lambda x : x[0] ,fail_rates))
    return answer
