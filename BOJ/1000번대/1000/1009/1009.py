for _ in range(int(input())):
    print(pow(*map(int, input().split()), 10) or 10)