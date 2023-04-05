NOTATION = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'

num, n = input().split()
num, n =  int(num), int(n)
st = ''
while(num > 0):
    try:
        st += NOTATION[num % n]
        num = num // n
    except:
        break
st = st[::-1]
print(st)
   