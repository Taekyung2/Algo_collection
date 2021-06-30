k, n = map(int, input().split())
arr = [int(input()) for _ in range(k)]
lo, hi = 1, max(arr)
while lo <= hi:
    mid = (lo + hi) // 2
    cnt = sum(d // mid for d in arr)
    if cnt < n:
        hi = mid - 1
    else:
        lo = mid + 1
print(hi)