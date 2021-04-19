min, max = map(int, input().split())

chk = [1] * (max - min + 1)
for n in range(2, int(max ** 0.5) + 1):
    square = n ** 2
    i = min // square
    if square * i < min:
        i += 1
    while square * i <= max:
        chk[square * i - min] = 0
        i += 1
print(sum(chk))