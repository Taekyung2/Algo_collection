s = input()
a, b = ('0' + s).count('01'), ('1' + s).count('10')
print(min(a, b))