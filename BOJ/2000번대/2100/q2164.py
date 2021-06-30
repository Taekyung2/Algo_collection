from collections import deque
arr = deque(range(1, int(input()) + 1))
while len(arr) > 1:
    arr.popleft()
    arr.append(arr.popleft())
print(arr[0])