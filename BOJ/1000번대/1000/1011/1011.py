import math
for _ in range(int(input())):
    x, y = map(int, input().split())
    print(math.ceil(2 * math.sqrt(y - x) - 1))