from bisect import bisect_left, bisect_right

def count_by_range(a,left_value, right_value):
    left_idx = bisect_left(a,left_value)
    right_idx = bisect_right(a, right_value)
    return right_idx-left_idx


def solution(words, queries):
    array = [[] for _ in range(10001)]
    reverse_array =[[] for _ in range(10001)]   
    answer = []
    for w in words:
        array[len(w)].append(w)
        reverse_array[len(w)].append(w[::-1])
        
    for i in range(10001):
        array[i].sort()
        reverse_array[i].sort()
    
    
    for q in queries:
        if (q[0]!='?'):
            res = count_by_range(array[len(q)],q.replace('?','a'),q.replace('?','z'))
        else:
            res = count_by_range(reverse_array[len(q)],q[::-1].replace('?','a'),q[::-1].replace('?','z'))
        
        answer.append(res)
    
    return answer