n = input()
while n != "0":
    print(["no", "yes"][n == n[::-1]])
    n = input()