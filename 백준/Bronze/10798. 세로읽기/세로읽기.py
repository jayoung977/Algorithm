a = [ list(input()) for i in range(5)]
col = max([ len(li) for li in a])

string = ''
for i in range(col):
    for j in range(len(a)):
        try:
            string += str(a[j][i])
        except:
            pass
print(string)