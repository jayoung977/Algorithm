def solution(phone_book):
    d ={}
    for p in phone_book:
        d[p] =1
    for p in phone_book:
        temp = ""
        for n in p:
            temp+=n
            if temp in d and temp != p:
                return False
        
        
    # while(cnt<len(phone_book)-1):
    #     part = phone_book[cnt]
    #     h = hash(part)
    #     for i in range(cnt+1, len(phone_book)):
    #         if part[0] != phone_book[i][0]:
    #             break
    #         if h - hash(phone_book[i][:len(part)]) == 0:
    #             return False
    #     cnt+=1

    return True