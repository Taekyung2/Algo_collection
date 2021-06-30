import sys
n = int(input())
arr = list(map(int, input().split()))
arr.sort()
ret, sum = [], sys.maxsize
for i in range(n - 2):
    left, right = i + 1, n - 1
    while left < right:
        dif = arr[i] + arr[left] + arr[right]
        if sum > abs(dif):
            ret, sum = [arr[i], arr[left], arr[right]], abs(dif)
        if dif < 0:
            left += 1
        elif dif > 0:
            right -= 1
        else:
            print(arr[i], arr[left], arr[right])
            exit()
print(' '.join(map(str, ret)))
