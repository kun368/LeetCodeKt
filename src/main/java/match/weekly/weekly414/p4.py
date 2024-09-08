from utils.python.predef import *

N = 50
moves = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]


def bfs_all_pairs():
    dist = {}
    for x in range(N):
        for y in range(N):
            dist[(x, y)] = [[sys.maxsize] * N for _ in range(N)]
            queue = deque([(x, y)])
            dist[(x, y)][x][y] = 0
            while queue:
                cx, cy = queue.popleft()
                for dx, dy in moves:
                    nx, ny = cx + dx, cy + dy
                    if 0 <= nx < N and 0 <= ny < N and dist[(x, y)][nx][ny] == sys.maxsize:
                        dist[(x, y)][nx][ny] = dist[(x, y)][cx][cy] + 1
                        queue.append((nx, ny))
    return dist


dist = bfs_all_pairs()
print('----')


class Solution:
    def maxMoves(self, kx: int, ky: int, positions: List[List[int]]) -> int:
        n = len(positions)

        @cache
        def dfs(mask, cur_x, cur_y, turn):
            if mask == 0:
                return 0
            if turn == 0:  # Alice's turn, maximize
                best = -sys.maxsize
                for i in range(n):
                    if mask & (1 << i):
                        next_mask = mask ^ (1 << i)
                        target_x, target_y = positions[i]
                        cost = dist[(cur_x, cur_y)][target_x][target_y]
                        best = max(best, cost + dfs(next_mask, target_x, target_y, 1 - turn))
            else:  # Bob's turn, minimize
                best = sys.maxsize
                for i in range(n):
                    if mask & (1 << i):
                        next_mask = mask ^ (1 << i)
                        target_x, target_y = positions[i]
                        cost = dist[(cur_x, cur_y)][target_x][target_y]
                        best = min(best, cost + dfs(next_mask, target_x, target_y, 1 - turn))
            return best

        return dfs((1 << n) - 1, kx, ky, 0)


if __name__ == '__main__':
    print(Solution().maxMoves(kx=1, ky=1, positions=[[0, 0]]))
    print(Solution().maxMoves(kx=0, ky=2, positions=[[1, 1], [2, 2], [3, 3]]))
    print(Solution().maxMoves(kx=0, ky=0, positions=[[1, 2], [2, 4]]))
