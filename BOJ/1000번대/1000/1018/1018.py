n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
ret = 64
for i in range(n - 7):
    for j in range(m - 7):
        cnt = 0
        for y in range(i, i + 8):
            for x in range(j, j + 8):
                if ('W' if y % 2 == x % 2 else 'B') == arr[y][x]:
                    cnt += 1
        ret = min(ret, cnt)
        ret = min(ret, 64 - cnt)
print(ret)