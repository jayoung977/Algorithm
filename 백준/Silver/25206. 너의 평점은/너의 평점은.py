grade2score = {
    'A+':4.5,
    'A0':4.0,
    'B+':3.5,
    'B0':3.0,
    'C+':2.5,
    'C0':2.0,
    'D+':1.5,
    'D0':1.0,
    'F':0.0
}
total_credit = 0
total_score = 0
while(True):
    try:
        classname, credit, grade = input().split()
        credit = float(credit)
        if grade == 'P':
            pass
        else:
            total_credit += credit
            total_score += credit*grade2score[grade]
            
    except:  
        print(total_score/total_credit)     
        break