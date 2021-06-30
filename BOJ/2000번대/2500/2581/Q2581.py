M = int(input())
N = int(input())

prime = [False for _ in range(N + 1)]
for i in range(2, N + 1):
    if not prime[i]:
        for j in range(2 * i, N + 1, i):
            prime[j] = True

prime_num = [i for i in range(M, N + 1) if not prime[i] and i >= 2]
if not len(prime_num):
    print(-1)
    exit(0)
print(sum(prime_num))
print(min(prime_num))