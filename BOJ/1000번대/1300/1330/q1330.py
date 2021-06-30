a, b = map(int, input().split())
if a < b:
    ret = '<'
elif a > b:
    ret = '>'
else:
    ret = "=="
print(ret)
