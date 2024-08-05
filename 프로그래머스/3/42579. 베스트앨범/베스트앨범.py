
def solution(genres, plays):
    d = {}
    l = {}
    for i in range(len(genres)):
        if genres[i] not in d:
            d[genres[i]]= 0
            l[genres[i]]= []
        d[genres[i]] += plays[i]
        l[genres[i]].append([plays[i],i])
    for genre in d:
        d_sorted = sorted(d, key=lambda x:d[x], reverse=True)
        l[genre] = sorted(l[genre],key=lambda x:x[0],reverse=True)[:2]
        l[genre] = [ y for x,y in l[genre]]
    answer = []
    for genre in d_sorted:
        answer += l[genre]
        
        
    # print(d_sorted)
    # print(l)
    
#     for genre in d:
        
#         answer

    
    return answer