def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i]+n)
    answer = len(dist)+1
    visited = [False  for _ in range(len(dist))]
    perm(dist,len(dist),[],visited)
        
    return answer
start = 0
# def perm(arr, r):
#     arr = sorted(arr)
#     visited = [False  for _ in range(len(arr))]
    
def perm(arr,r,chosen,visited):
    global start
    if len(chosen) == r:
        start+=1
        print(start,":",chosen)
        count=1
        # position = weak[]
        return 
    for i in range(len(arr)):
        if(visited[i]): continue
        visited[i] = True
        chosen.append(arr[i])
        perm(arr,r,chosen,visited)
        chosen.pop()
        visited[i] = False




    
    