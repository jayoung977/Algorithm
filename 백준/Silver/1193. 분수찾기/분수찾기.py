n =  int(input())
i = 1
last_num = 1
while(n > last_num):
    i += 1  
    last_num = last_num + i  
n2 = last_num - n 
if (i%2!=0):
    print(f'{n2+1}/{i-n2}')
else:
    print(f'{i-n2}/{n2+1}')
