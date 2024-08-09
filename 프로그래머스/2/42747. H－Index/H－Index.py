def solution(citations):
    paper_len = len(citations)
    answer = 0
    for i in range(1, paper_len+1):
        papers = list(filter(lambda x: x>=i,citations))
        if len(papers) >= i:
            answer = i
    
    return answer