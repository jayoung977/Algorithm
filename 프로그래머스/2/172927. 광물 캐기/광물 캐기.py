def solution(picks, minerals):
    dic = {"diamond":0,"iron":1,"stone":2}
    s_p = sum(picks)
    num = s_p * 5
    if len(minerals)>s_p:
        minerals = minerals[:num]
        
    m_list = [[0,0,0] for _ in range(len(minerals)//5+1)]
    for i in range(len(minerals)):
        idx = dic[minerals[i]]
        m_list[i//5][idx]+=1
    m_list.sort(key=lambda x: (-x[0],-x[1],-x[2]))
    
    answer = 0
    for d,i,s in m_list:
        if picks[0]==0 and picks[1]==0 and picks[2]==0:
            break
        elif picks[0]>0:
            answer+=(d+i+s)
            picks[0]-=1
            continue
        elif picks[1]>0:
            answer+=(d*5+i+s)
            picks[1]-=1
            continue
        elif picks[2]>0:
            answer+=(d*25+i*5+s)
            picks[2]-=1
            continue
    
    return answer