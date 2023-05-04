from utils.python.predef import *


class Solution:
    def hardestWorker(self, n: int, logs: List[List[int]]) -> int:
        prev = 0
        for i in logs:
            i.append(i[1] - prev)
            prev = i[1]
        logs.sort(key=lambda x: (-x[2], x[0]))
        return logs[0][0]


if __name__ == '__main__':
    print(Solution().hardestWorker(
        n=10, logs=[[0, 3], [2, 5], [0, 9], [1, 15]]))
    print(Solution().hardestWorker(
        n=26, logs=[[1, 1], [3, 7], [2, 12], [7, 17]]))
    print(Solution().hardestWorker(n=2, logs=[[0, 10], [1, 20]]))
