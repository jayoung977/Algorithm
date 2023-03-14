import sys
total, num = map(int,sys.stdin.readline().split())
li = list(map(int,sys.stdin.readline().split()))
for n in li:
    if n < num:
        print(n, end=' ')