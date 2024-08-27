s = list(map(int,list(input())))

count = [0]*2
for i in range(len(s)-1):
    if s[i]!=s[i+1]:
        count[s[i]]+=1
count[s[-1]]+=1

answer = min(count)

print(answer)