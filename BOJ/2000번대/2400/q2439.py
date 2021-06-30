n = int(input())
for i in range(n):
    s = ""
    for j in range(n - i - 1):
        s += " "
    for j in range(i + 1):
        s += "*"
    print(s)