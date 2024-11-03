from utils.python.predef import *


class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        visited = [[float('inf')] * m for _ in range(n)]
        pq = [(0, 0, 0)]  # (time, x, y)

        while pq:
            time, x, y = heappop(pq)
            if (x, y) == (n - 1, m - 1):
                return time
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    new_time = max(time + 1, moveTime[nx][ny] + 1)
                    if new_time < visited[nx][ny]:
                        visited[nx][ny] = new_time
                        heappush(pq, (new_time, nx, ny))


if __name__ == '__main__':
    print(Solution().minTimeToReach(moveTime=[[0, 4], [4, 4]]))
    print(Solution().minTimeToReach(moveTime=[[0, 0, 0], [0, 0, 0]]))
    print(Solution().minTimeToReach(moveTime=[[0, 1], [1, 2]]))
    print(Solution().minTimeToReach(moveTime=[[17, 56], [97, 80]]))
