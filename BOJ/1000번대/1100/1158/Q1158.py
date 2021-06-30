N, K = map(int, input().split())
q = list(range(1, N + 1))
ret = []
pos = 0

for _ in range(N):
    pos += K - 1
    pos %= len(q)
    ret.append(str(q[pos]))
    del q[pos]
print('<' + ', '.join(ret) + '>')