def solution(distance, rocks, n):
    rocks.append(distance)
    rocks.sort()
    left,right=0,distance
    answer = 0
    while left<=right:        
        mid = (left+right)//2
        prev_rock=0
        delete=0
        for rock in rocks:
            dist=rock-prev_rock
            if dist<mid:
                delete+=1
                if delete>n:
                    break
            else:
                prev_rock=rock
        if delete>n:
            right=mid-1
        else:
            left=mid+1
            answer = max(answer,mid)
    
    return answer