import sys
stack = []
t = int(sys.stdin.readline())
for i in range(1, t+1):
    command = sys.stdin.readline()
    if 'push' in command:
        command, num = command.split()
        stack.append(num)
    elif 'pop' in command:
        if not stack:
            print(-1)
        else:
            print(stack.pop())
    elif 'size' in command:
        print(len(stack))
    elif 'empty' in command:
        if not stack:
            print(1)
        else:
            print(0)
    elif 'top' in command:
        if not stack:
            print(-1)
        else:
            print(stack[-1])