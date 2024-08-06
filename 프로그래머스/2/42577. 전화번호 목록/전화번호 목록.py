def solution(phone_book):
    d = dict.fromkeys(phone_book,1)
    for num in phone_book:
        temp = ""
        for n in num:
            temp+=n
            if temp in d and temp!=num:
                return False
    return True