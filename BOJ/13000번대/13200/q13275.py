s = input()


def expand(left: int, right: int) -> int:
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return right - left - 1


if len(s) < 2 or s == s[::-1]:
    print(len(s))
    exit()

ret = 0
for i in range(len(s) - 1):
    ret = max(ret, expand(i, i + 1), expand(i, i + 2))
print(ret)
