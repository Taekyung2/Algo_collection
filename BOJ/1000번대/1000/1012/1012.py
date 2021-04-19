import sys
read = sys.stdin.readline
getarr = lambda: map(int, read().split())


def bfs(y, x):
    q = [(y, x)]
    while q:
        y, x = q.pop()
        board[y][x] = 0
        for ny, nx in [(y + 1, x), (y - 1, x), (y, x + 1), (y, x - 1)]:
            if 0 <= ny < N and 0 <= nx < M and board[ny][nx]:
                q += [(ny, nx)]


for _ in range(int(read())):
    M, N, K = getarr()
    board = [[0] * M for _ in range(N)]
    ret = 0
    for _ in range(K):
        v, w = getarr()
        board[w][v] = 1

    for i in range(N):
        while any(board[i]):
            bfs(i, board[i].index(1))
            ret += 1
    print(ret)