from utils.python.predef import *

from dataclasses import dataclass


@dataclass(frozen=True)
class Node:
    x: int
    y: int
    num: int


class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        M, N = len(grid), len(grid[0])
        if grid[0][0] != '(' or grid[M - 1][N - 1] != ')' or (M + N) % 2 != 1:
            return False

        vis = {Node(0, 0, 1)}
        qu = deque(vis)
        while qu:
            top = qu.pop()
            for dx, dy in [(0, 1), (1, 0)]:
                if (nx := top.x + dx) >= M or (ny := top.y + dy) >= N:
                    continue
                if (nn := top.num + (1 if grid[nx][ny] == '(' else -1)) < 0:
                    continue
                if nx == M - 1 and ny == N - 1 and nn == 0:
                    return True
                if M + N - nx - ny - 2 < nn:
                    continue
                if (next := Node(nx, ny, nn)) in vis:
                    continue
                vis.add(next)
                qu.append(next)
        return False


if __name__ == '__main__':
    print(Solution().hasValidPath(grid=[["(", "(", "("], [")", "(", ")"], ["(", "(", ")"], ["(", "(", ")"]]))
    print(Solution().hasValidPath(grid=[[")", ")"], ["(", "("]]))
