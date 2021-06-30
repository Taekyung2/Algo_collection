f = input().count
print(max((f('6') + f('9') + 1) // 2, max(f(n) for n in '01234578')))
