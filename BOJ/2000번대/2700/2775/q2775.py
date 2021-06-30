for _ in range(int(input())):
    k, n = int(input()), int(input())
    arr = [i for i in range(1, n + 1)]
    for _ in range(k):
        for j in range(1, n):
            arr[j] += arr[j - 1]
    print(arr[-1])