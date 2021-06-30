n = int(input())
chk = False
for i in range(n + 1):
    if n == sum(map(int, str(i))) + i:
        chk = True
        break
print([0, i][chk])