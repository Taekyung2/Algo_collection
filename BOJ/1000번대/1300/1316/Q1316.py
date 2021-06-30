n = int(input())
ret = 0
for _ in range(n):
    s = input()
    if list(s) == sorted(s, key=s.find):
        ret += 1
print(ret)