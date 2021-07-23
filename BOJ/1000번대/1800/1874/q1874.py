n = int(input())
arr = [int(input()) for _ in range(n)]
n, s, ret = 0, [], []
for i in arr:
    if s and s[-1] > i:
        print("NO")
        exit()
    while not s or s[-1] < i:
        n += 1
        s.append(n)
        ret.append('+')
    s.pop()
    ret.append('-')
print("\n".join(ret))