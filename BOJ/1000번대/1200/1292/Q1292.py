A, B = map(int, input().split())
li = [0]
for i in range(1, 1000):
    li += [i] * i
print(sum(li[A:B + 1]))
