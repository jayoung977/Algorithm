# import time
# start_time = time.time()
T = int(input())
for _ in range(T):
    W = list(input())
    K = int(input())

    s = set(W)
    arr = []
    flag = False
    for n in s:
        if W.count(n) >= K:
            arr.append(n)
            flag = True
    if flag == False:
        print(-1)
        continue
    maxN = 0
    minN = 1e9
    for n in arr:
        idxs = [i for i in range(len(W)) if W[i] == n]
        for i in range(0, len(idxs)):
            if (i+(K-1)) < len(idxs):
                length = idxs[i+(K-1)] - idxs[i] + 1
                maxN = max(maxN, length)
                minN = min(minN, length)

                # print(i, i+(K-1))

    print(minN, maxN)
# end_time = time.time()
# print("time:", end_time-start_time)