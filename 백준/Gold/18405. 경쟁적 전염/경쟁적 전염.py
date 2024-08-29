import heapq
def solution(N, K, arr, S, X, Y):

    def collect(arr):
        k_list = []
        for i in range(N):
            for j in range(N):
                if arr[i][j]!=0:
                    k_list.append((arr[i][j],i,j))
        return k_list

    dr = [0,1,0,-1]
    dc = [1,0,-1,0]

    k_list = collect(arr)
    heapq.heapify(k_list)
    time=0
    while time < S:
        next_k_list = []
        while k_list:
            x,r,c = heapq.heappop(k_list)
            for d in range(4):
                nr,nc = r+dr[d],c+dc[d]
                if not(0<=nr<N and 0<=nc<N) or arr[nr][nc]!=0:
                    continue
                if arr[nr][nc]==0:
                    if nr==X-1 and nc==Y-1:
                        return x
                    arr[nr][nc]=x
                    next_k_list.append((x,nr,nc))
        for item in next_k_list:
            heapq.heappush(k_list,item)
        time+=1
        
    return arr[X-1][Y-1]

N,K = map(int,input().split())
arr = [ list(map(int,input().split())) for _ in range(N)]
S,X,Y = map(int,input().split())

print(solution(N, K, arr, S, X, Y))