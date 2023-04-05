quarter = 25
dime = 10
nickel = 5
penny = 1

n = int(input())
for i in range(n):
    exchange = int(input())
    q_num =  exchange // quarter
    d_num =  (exchange % quarter) // dime
    n_num = (exchange % quarter % dime) // nickel
    p_num = (exchange % quarter % dime % nickel) // penny
    print(q_num, d_num, n_num, p_num)