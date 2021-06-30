N = int(input())
s = set()
for _ in range(N):
    s.add(input())
print('\n'.join(sorted(list(s), key=lambda x: (len(x), x))))