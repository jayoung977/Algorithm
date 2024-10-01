def solution(book_time):
    def convert_time(string):
        h,m = map(int,string.split(":"))
        return h*60+m
    for i in range(len(book_time)):
        book_time[i][0]=convert_time(book_time[i][0])
        book_time[i][1]=convert_time(book_time[i][1])+10
    book_time.sort(key=lambda x:x[0])
    rooms=[]
    rooms.append([book_time[0]])

    for i in range(1,len(book_time)):
        flag=False
        for r in rooms:
            while r and r[-1][1] <= book_time[i][0]:
                r.pop()
            if not flag and not r:
                flag=True
                r.append(book_time[i])
        if not flag:
            rooms.append([book_time[i]])

    return len(rooms)