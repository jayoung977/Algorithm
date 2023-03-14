import sys
total = int(sys.stdin.readline())   
li = list(map(int,sys.stdin.readline().split()))
last = int(sys.stdin.readline())  
print(li.count(last))