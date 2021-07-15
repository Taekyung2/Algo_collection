a = [0, 0] + [1] * 1000
for i in range(2, 1001):
    if a[i]:
        for j in range(i * i, 1001, i):
            a[j] = 0
input()
print(len(list(filter(lambda x: a[x], map(int, input().split())))))