word =list(input())
alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
li = []
for i in alpha:
    if i in word:
        li.append(word.index(i))
    else:
        li.append(-1)
print(*li)
        