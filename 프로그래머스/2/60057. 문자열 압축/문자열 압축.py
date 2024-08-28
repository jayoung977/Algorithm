def find(n):
    li = set()
    for i in range(1,int(n**(1/2))+1):
        if n%i==0:
            li.add(i)
            li.add(n//i)
    li.remove(n)
    return list(li)
    

def solution(s):
    num_list = find(len(s))
    answer = len(s)
    for n in range(1,len(s)//2+1):
        # print("n:{}".format(n))
        temp=""
        i=0
        while i+2*n<=len(s):
            # print(i)
            # print("s[{}:{}]==s[{}:{}]".format(i,i+n,i+n,i+2*n))
            cnt=1
            while s[i:i+n]==s[i+n:i+2*n]:
                cnt+=1
                i+=n
            if cnt!=1:
                temp+=str(cnt)+s[i:i+n]
            else:
                temp+=s[i:i+n]
            i+=n
        # if cnt==1 or :
        if cnt==1 or i+2*n>len(s):
            temp+=s[i:]
        # print(temp)
        answer = min(len(temp),answer)
    
    return answer