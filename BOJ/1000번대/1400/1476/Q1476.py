e, s, m = map(int, input().split())
for i in range(10000):
    a, b, c = i % 15, i % 28, i % 19
    if (e, s, m) == (a + 1, b + 1, c + 1):
        print(i + 1)
        break