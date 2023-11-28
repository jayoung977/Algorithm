friends = []
def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i]+n)
    answer = len(dist)+1
    visited = [False  for _ in range(len(dist))]
    perm(dist,len(dist),[],visited)

    for start in range(length):
        for chosen in friends:
            count=1
            position = weak[start] + chosen[count-1]
            for index in range(start, start + length):
                if position < weak[index]:
                    count +=1
                    if(count > len(dist)):
                        break
                    position =  weak[index] + chosen[count-1]
            answer = min(answer,count)
        
    if(answer > len(dist)):
        answer = -1
    return answer


def perm(arr,r,chosen,visited):
    global friends
    if len(chosen) == r:
        friends.append(chosen[:])
        return 
    for i in range(len(arr)):
        if(visited[i]): continue
        visited[i] = True
        chosen.append(arr[i])
        perm(arr,r,chosen,visited)
        chosen.pop()
        visited[i] = False




    
    