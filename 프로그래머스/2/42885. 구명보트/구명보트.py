import heapq
from collections import deque
def solution(people, limit):
    answer = 0
    # heapq.heapify(people)
    people.sort()
    queue = deque(people)
    # left_cursor = 0
    # right_cursor = len(people)-1
    # while people:
    #     heapq.heappop(people)
    while len(queue)>=2:
        right = queue.pop()
        if queue[0]+right<=limit:
            queue.popleft()
        answer+=1
    if queue:
        answer+=1

    return answer