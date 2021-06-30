s = input().upper()
m = 0
for i in set(s) :
    c = s.count(i)
    if m < c : ret, m = i, c
    elif m == c : ret = '?'
print(ret)