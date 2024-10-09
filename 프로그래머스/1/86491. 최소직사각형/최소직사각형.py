def solution(sizes):
    for i,(w,h) in enumerate(sizes):
        if w<h:
            sizes[i]=[h,w]
    h,w = zip(*sizes)
        
    answer = max(h)*max(w)
    return answer