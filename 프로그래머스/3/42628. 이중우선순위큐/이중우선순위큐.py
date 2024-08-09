import heapq
def solution(operations):
    heap = []
    for i in operations:
        op,num = i.split(" ")
        num=int(num)
        if op=="I":
            heapq.heappush(heap,num)
        elif len(heap) > 0:
            if op=="D" and num==1:
                heap_max = [ h*-1 for h in heap]
                heapq.heapify(heap_max)
                heapq.heappop(heap_max)
                heap = [ h*-1 for h in heap_max]
                heapq.heapify(heap)
            else:
                heapq.heappop(heap)

    answer = [0,0]
    # print(heap)
    if len(heap) == 1:
        
        n = heapq.heappop(heap)
        answer = [n,n]
    elif len(heap) > 1:
        n = heapq.heappop(heap)
        heap_max = [ h*-1 for h in heap]
        heapq.heapify(heap_max)
        m = heapq.heappop(heap_max)*-1
        # print(n,m)
        answer = [m,n]
    return answer