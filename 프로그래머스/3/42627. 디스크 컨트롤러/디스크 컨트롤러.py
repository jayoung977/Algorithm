from collections import deque
import heapq
def solution(jobs):
    len_jobs = len(jobs)
    #deque는 요청순 정렬
    queue = deque(sorted([(x[1], x[0]) for x in jobs], key=lambda x: (x[1], x[0])))
    heap = []
    #하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리
    heapq.heappush(heap,(queue.popleft()))
    total,cursor = 0,0

    while len(heap)>0: 
        spend,start = heapq.heappop(heap)
        cursor = max(cursor+spend,start+spend)
        total += cursor-start
        # print(spend,start,cursor,total)
        while len(queue)>0 and queue[0][1] <= cursor:
            heapq.heappush(heap,queue.popleft())
        if len(queue)>0 and  len(heap)==0:
            heapq.heappush(heap,queue.popleft())

    return total//len_jobs



# def solution(jobs):
#     len_jobs = len(jobs)
#     jobs.sort(key=lambda x:(x[0],x[1]))

#     queue = deque(jobs)
#     init = queue.popleft()
#     total = init[1]-init[0]
#     cursor = init[0]+init[1]
    
#     while queue:
#         current = queue.popleft()
#         spend = current[1]
#         start = current[0]
#         if any(x <= cursor and y <= spend for x,y in queue): #길이 같을 경우 자동 정렬이 안되서 틀림 + 시간 초과 => 힙써야함
#             queue.append(current)
#         else:
#             cursor = max(cursor+spend,start+spend)
#             total += (cursor-start)
#     answer = total//len_jobs
#     return answer