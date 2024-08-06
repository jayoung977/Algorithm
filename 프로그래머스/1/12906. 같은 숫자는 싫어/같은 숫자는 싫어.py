from collections import deque
def solution(arr):
    que = deque()
    que.append(arr[0])
    for i in range(1,len(arr)):
        if arr[i] != que[-1]:
            que.append(arr[i])
    

    return list(que)