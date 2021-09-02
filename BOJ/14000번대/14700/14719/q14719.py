h, w = map(int, input().split())
height = list(map(int, input().split()))
ret = 0
l, r = 0, w - 1
l_max, r_max = height[l], height[r]
while l < r:
    l_max, r_max = max(l_max, height[l]), max(r_max, height[r])
    if l_max <= r_max:
        ret += l_max - height[l]
        l += 1
    else:
        ret += r_max - height[r]
        r -= 1
print(ret)
