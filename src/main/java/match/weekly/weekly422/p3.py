from utils.python.predef import *


class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        visited = [[float('inf')] * m for _ in range(n)]
        pq = [(0, 0, 0, 0)]  # (time, x, y, move_count)

        while pq:
            time, x, y, move_count = heappop(pq)
            if (x, y) == (n - 1, m - 1):
                return time
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    move_time = 1 if move_count % 2 == 0 else 2
                    new_time = max(moveTime[nx][ny] + move_time, time + move_time)
                    if new_time < visited[nx][ny]:
                        visited[nx][ny] = new_time
                        heappush(pq, (new_time, nx, ny, move_count + 1))


if __name__ == '__main__':
    print(Solution().minTimeToReach(moveTime=[[0, 4], [4, 4]]))
    print(Solution().minTimeToReach(moveTime=[[0, 0, 0, 0], [0, 0, 0, 0]]))
    print(Solution().minTimeToReach(moveTime=[[0, 1], [1, 2]]))
