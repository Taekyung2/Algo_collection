input()
a = set(input().split())
input()
print("\n".join(map(lambda x : str(int(x in a)), input().split())))