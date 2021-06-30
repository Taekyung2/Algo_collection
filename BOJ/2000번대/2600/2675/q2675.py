for i in range(int(input())):
  a, b = input().split()
  print("".join(i * int(a) for i in b))