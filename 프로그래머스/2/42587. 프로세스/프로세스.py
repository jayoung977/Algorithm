def solution(priorities, location):
    jobs = len(priorities)
    cursor = 0
    answer = 0
    while True:
        if max(priorities)==priorities[cursor%jobs]:
            priorities[cursor%jobs]=0
            answer+=1
            if cursor%jobs==location:
                return answer

        cursor+=1
    return answer