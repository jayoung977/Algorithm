def solution(n, times):
    times.sort()
    left,right=0,times[-1]*n
    answer = right
    while left<=right:
        mid=(left+right)//2
        people=0
        for t in times:
            people+=mid//t
            if people >= n:
                break
        if people>=n:
            answer=min(mid,answer)
            right=mid-1
        else:
            left=mid+1
    return answer