arr = [-1 for _ in range(26)]
for i, c in enumerate(map(lambda x : ord(x) - ord('a'), input())):
    if arr[c] == -1:
        arr[c] = i
print(" ".join(str(i) for i in arr))