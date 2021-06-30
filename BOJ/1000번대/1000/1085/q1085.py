a = list(map(int, input().split()))
print(min(a[0], a[1], a[2] - a[0], a[3] - a[1]))