def solution(answers):
    players = [[],[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]
    scores = [0]*4
    # player2 = [2,1,2,3,2,4,2,5]
    # player3 = [3,3,1,1,2,2,4,4,5,5]
    for i in range(len(answers)):
        scores[1]+= 1 if answers[i] == players[1][i%len(players[1])] else 0
        scores[2]+= 1 if answers[i] == players[2][i%len(players[2])] else 0
        scores[3]+= 1 if answers[i] == players[3][i%len(players[3])] else 0
        
    answer = [ i for i in range(1,len(scores)) if max(scores) == scores[i]  ]
    return answer