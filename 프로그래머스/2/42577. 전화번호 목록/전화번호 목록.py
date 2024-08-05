def solution(phone_book):
    phone_book.sort()

    for p1,p2 in zip(phone_book,phone_book[1:]):
        if p2.startswith(p1) :
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