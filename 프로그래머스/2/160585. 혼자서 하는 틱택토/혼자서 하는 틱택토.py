
def solution(board):
    center_list = [(0, 1), (1, 0), (1, 1), (1, 2), (2, 2)]
    check_win = [
        [[(0, 0), (0, 2)]],
        [[(0, 0), (2, 0)]],
        [[(1, 0), (1, 2)], [(0, 1), (2, 1)], [(0, 0), (2, 2)], [(0, 2), (2, 0)]],
        [[(0, 2), (2, 2)]],
        [[(2, 0), (2, 2)]]
    ]
    
    O_cnt = 0
    X_cnt = 0
    O_wins = False
    X_wins = False
    
    # O와 X의 수 카운트
    for i in range(3):
        for j in range(3):
            if board[i][j] == "O":
                O_cnt += 1
            elif board[i][j] == "X":
                X_cnt += 1

    # 기본적인 수의 차이가 맞는지 확인
    if not (X_cnt <= O_cnt <= X_cnt + 1):
        return 0

    # 승리 조건 체크
    for i in range(3):
        # 가로와 세로 체크
        if board[i][0] == board[i][1] == board[i][2] and board[i][0] != ".":
            if board[i][0] == "O":
                O_wins = True
            else:
                X_wins = True
        if board[0][i] == board[1][i] == board[2][i] and board[0][i] != ".":
            if board[0][i] == "O":
                O_wins = True
            else:
                X_wins = True

    # 대각선 체크
    if board[0][0] == board[1][1] == board[2][2] and board[0][0] != ".":
        if board[0][0] == "O":
            O_wins = True
        else:
            X_wins = True
    if board[0][2] == board[1][1] == board[2][0] and board[0][2] != ".":
        if board[0][2] == "O":
            O_wins = True
        else:
            X_wins = True

    # 둘 다 승리하는 경우는 규칙 위반
    if O_wins and X_wins:
        return 0

    # O가 승리했을 때는 O가 한 수 더 많아야 함
    if O_wins and O_cnt != X_cnt + 1:
        return 0

    # X가 승리했을 때는 O와 X의 수가 같아야 함
    if X_wins and O_cnt != X_cnt:
        return 0

    # 아무도 승리하지 않았을 때는 기본적인 수의 차이만 확인
    return 1