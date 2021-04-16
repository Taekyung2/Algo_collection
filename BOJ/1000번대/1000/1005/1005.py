import sys

read = sys.stdin.readline

def dp(w):
    if cache[w] != -1:
        return cache[w]
    if not Ord[w]:
        return time[w]

    ret = 0
    for prev in Ord[w]:
        ret = max(ret, dp(prev) + time[w])
    cache[w] = ret
    return ret


for _ in range(int(read())):
    n, k = map(int, read().split())
    time = [0] + list(map(int, read().split()))
    Ord = [[] for x in range(n + 1)]
    for i in range(k):
        x, y = map(int, read().split())
        Ord[y] += [x]
    W = int(read())
    cache = [-1] * (n + 1)
    print(dp(W))