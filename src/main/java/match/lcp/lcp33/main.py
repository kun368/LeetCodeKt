from utils.python.predef import *


class Solution:
    def storeWater(self, bucket: List[int], vat: List[int]) -> int:
        if (mv := max(vat)) == 0:
            return 0
        ans = 1 << 30
        for i in range(1, mv + 1):
            ans = min(ans, i + sum(max(0, ((b - 1) // i) + 1 - a) for a, b in zip(bucket, vat)))
        return ans


if __name__ == '__main__':
    print(Solution().storeWater(bucket=[1, 3], vat=[6, 8]))
    print(Solution().storeWater(bucket=[9, 0, 1], vat=[0, 2, 2]))
    print(Solution().storeWater(bucket=[3, 2, 5], vat=[0, 0, 0]))
