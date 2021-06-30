n = int(input())


def check(s):
    s = s.lower()
    return s == s[::-1]


for i in range(n):
    print("Yes" if(check(input())) else "No")
