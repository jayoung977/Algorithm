from heapq import heappop,heappush
def solution(sequence, k):
    start_idx,end_idx=0,0
    sum_value=0
    hq = []
    for end_idx in range(len(sequence)):
        sum_value+=sequence[end_idx]
        while sum_value>k and start_idx<=end_idx:
            sum_value-=sequence[start_idx]
            start_idx+=1
            # print("start_idx:{},end_idx:{},sum_value:{}".format(start_idx,end_idx,sum_value))
        if sum_value==k:
            heappush(hq,[end_idx-start_idx,[start_idx,end_idx]])

    return heappop(hq)[1]