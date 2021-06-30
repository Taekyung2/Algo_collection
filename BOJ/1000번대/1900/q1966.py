for _ in range(int(input())):
    n, k = map(int, input().split())
    arr = list(enumerate(map(int, input().split())))
    j = 1
    while arr:
        a = arr.pop(0)
        if list(filter(lambda x: x[1] > a[1], arr)):
            arr.append(a)
            continue
        else:
            if a[0] == k:
                print(j)
                break
            else:
                j += 1