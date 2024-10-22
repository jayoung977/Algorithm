from collections import Counter
from heapq import heappop,heappush
def solution(k, tangerine):
    counter = Counter(tangerine)
    hq = []
    for key,cnt in counter.items():
        heappush(hq,(-cnt,key))
    # print(hq)
    answer = 0
    while hq and k>0:
        cnt,key = heappop(hq)
        k+=cnt
        answer+=1
        # print("cnt:{},key:{},k:{},answer:{}".format(cnt,key,k,answer))
        
        
        
    
    return answer