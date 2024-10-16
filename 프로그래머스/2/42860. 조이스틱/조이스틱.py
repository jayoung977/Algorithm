def min_updouwn(alpha):
    up = ord(alpha)-ord("A")
    down = ord("Z")-ord(alpha)+1
    return min(up,down)
    
def solution(name):
    
    sum_updown=0
    for alpha in name:
        sum_updown+=min_updouwn(alpha)
    
    min_leftright = len(name)-1
    for i in range(len(name)):
        cursor=i+1
        while cursor<len(name) and name[cursor]=="A":
            cursor+=1

        right2left = i * 2 + (len(name) - cursor)
        left2right = i + (len(name) - cursor) * 2
        min_leftright = min([right2left,left2right,min_leftright])

    return sum_updown+min_leftright