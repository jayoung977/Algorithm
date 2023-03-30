a = int(input())
last = 2 * a - 1
for i in range(last+1):
    if i+1 <= a:
        num = 2 * (i+1) - 1
        bin_num = (last - num)//2
        print(' '*bin_num + '*'*num)
    else:
        num = 2 * (2*a - (i+1)) - 1
        bin_num = (last - num)//2
        print(' '*bin_num + '*'*num)