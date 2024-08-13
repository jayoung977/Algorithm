def solution(brown, yellow):
    a = 1
    b = -(brown+4)/2
    c = brown+yellow
    check = b**2-4*a*c
    if check>0:
        return [(-b+check**(1/2))/(2*a),(-b-check**(1/2))/(2*a)]
    elif check==0:
        return [(-b+check**(1/2))/(2*a),(-b+check**(1/2))/(2*a)]
        
    # answer = []
    # return answer