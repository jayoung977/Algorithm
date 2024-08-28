import copy

def rotate(arr):
    new = [[0]*len(arr) for _ in range(len(arr[0]))]
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            new[j][len(arr)-1-i]=arr[i][j]
    return new

def solution(key, lock):
    n,m = len(lock),len(key)
    len_arr = n+2*(m-1)
    arr = [[0]*len_arr for _ in range(len_arr)]
    for i in range(n):
        for j in range(n):
            arr[m-1+i][m-1+j] = lock[i][j]
            
    rotated = rotate(key)
    origin_arr = copy.deepcopy(arr)
    for _ in range(4):
        for i in range(len_arr-m+1):
            for j in range(len_arr-m+1):
                #배열에 키 더하기
                for k in range(i,i+m):
                    for l in range(j,j+m):
                        arr[k][l]+=rotated[k-i][l-j]
                        
                #잠금장치 확인하기
                flag = False
                total = 0
                for k in range(m-1,m-1+n):
                    for l in range(m-1,m-1+n):
                        if arr[k][l]==2 or arr[k][l]==0:
                            flag=True
                            break
                        else:
                            total+=1
                    if flag:
                        break
                    if total == n*n:
                        return True
                # 배열 초기화
                arr = copy.deepcopy(origin_arr)
                              
        
        rotated = rotate(rotated)
    
    return False