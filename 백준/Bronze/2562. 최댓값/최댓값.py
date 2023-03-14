li = []
while(True):
    try:
        li.append(int(input()))
    except:
        break
print(max(li))
print(int(li.index(max(li)))+1)