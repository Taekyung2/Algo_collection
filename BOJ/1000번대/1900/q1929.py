m, n = map(int, input().split())
x = [0, 0] + [1] * (n - 1)
for i in range(2, n + 1):
    if x[i] and i >= m:
        print(i)
    for j in range(i * i, n + 1, i):
        x[j] = 0