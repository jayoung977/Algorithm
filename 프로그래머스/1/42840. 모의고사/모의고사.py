def solution(answers):
    student = [[1, 2, 3, 4, 5], 
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    
    # len_ans = len(answers)
    score=[0]*3
    max_score = 0
    for s in range(3):
        for i,answer in enumerate(answers):
            if answer == student[s][i%len(student[s])]:
                score[s]+=1
        if max_score<score[s]:
            max_score=score[s]
    answer = []        
    for i,sc in enumerate(score):
        if sc == max_score:
            answer.append(i+1)
    
    return answer