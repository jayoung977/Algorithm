n = int(input())
li = list(map(int, input().split()))
max_score = max(li)
li = [(i/max_score)*100 for i in li] 
print(sum(li)/n)