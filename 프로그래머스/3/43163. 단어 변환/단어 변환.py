from collections import Counter
def solution(begin, target, words):
    def dfs(word,n):
        # print(word,n)
        if word == target:
            answer[0] = min(n,answer[0])
        cnt_word=Counter(word)
        for nex in words:
            # print(len(cnt_word-Counter(nex)))
            if nex in visited or len(cnt_word-Counter(nex))!=1:
                continue
            visited.add(nex)
            dfs(nex,n+1)
            visited.remove(nex)
            
            
            
        
    answer = [1e9]
    visited = set()
    visited.add(begin)
    dfs(begin,0)
    if answer[0] == 1e9:
        return 0
    return answer[0]