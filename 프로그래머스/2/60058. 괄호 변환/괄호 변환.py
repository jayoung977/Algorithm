def divide(string):
    stack = []
    stack.append(string[0])
    u,v = string[0],""
    for s in string[1:]:
        if stack[-1]==s:
            stack.append(s)
            u+=s
        else:
            stack.pop()
            u+=s
        if not stack:
            v = string[len(u):]
            break
    
    return u,v

def check(string):
    if string[0]!="(":
        return False
    stack = []
    stack.append(string[0])
    for s in string[1:]:
        if s == ")":
            if not stack:
                return False
            stack.pop()
        else:
            stack.append(s)
    return True

def change(string):
    temp = ""
    for s in string:
        if s == "(":
            temp+=")"
        else:
            temp+="("
    return temp

def make(w):
    if w=="":
        return w    
    u,v = divide(w)    
    if check(u):
        return u+make(v)
    else:
        temp ="("+make(v)+")"
        temp_u=change(u[1:-1])
        return temp+temp_u


def solution(p):
    return make(p)