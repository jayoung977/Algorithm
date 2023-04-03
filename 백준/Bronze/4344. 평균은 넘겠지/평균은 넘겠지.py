num = int(input())
per_li = []
for i in range(num):
    li = list(map(int,input().split()))
    total_num = li[0]
    score_li = li[1:]
    mean = sum(score_li) / total_num
    upper_std = len([ i for i in score_li if i > mean])
    per =  "%0.3f%%" % (upper_std/total_num*100)
    print(per)