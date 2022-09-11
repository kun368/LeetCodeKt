from utils.python.predef import *


class Node:
    def __init__(self, quality, min_wage):
        self.quality = quality
        self.min_wage = min_wage
        self.rate = min_wage / quality


class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        workers = [Node(q, w) for q, w in zip(quality, wage)]
        quality_sum = 0
        hp = []
        ans = 1 << 30
        for w in sorted(workers, key=lambda x: x.rate):
            heapq.heappush(hp, -w.quality)
            quality_sum += w.quality
            if len(hp) > k:
                quality_sum += heapq.heappop(hp)
            if len(hp) == k:
                ans = min(ans, quality_sum * w.rate)
        return ans


if __name__ == '__main__':
    print(Solution().mincostToHireWorkers(quality=[10, 20, 5], wage=[70, 50, 30], k=2))
    print(Solution().mincostToHireWorkers(quality=[3, 1, 10, 10, 1], wage=[4, 8, 2, 2, 7], k=3))
