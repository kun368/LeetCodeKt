from utils.python.predef import *


class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], numWanted: int, useLimit: int) -> int:
        counter = defaultdict(int)
        ans = 0
        for v, l in sorted(zip(values, labels), key=lambda x: -x[0]):
            if counter[l] >= useLimit: continue
            ans += v
            counter[l] += 1
            if (numWanted := numWanted - 1) <= 0:
                break
        return ans


if __name__ == '__main__':
    print(Solution().largestValsFromLabels(values=[5, 4, 3, 2, 1], labels=[1, 1, 2, 2, 3], numWanted=3, useLimit=1))
    print(Solution().largestValsFromLabels(values=[5, 4, 3, 2, 1], labels=[1, 3, 3, 3, 2], numWanted=3, useLimit=2))
    print(Solution().largestValsFromLabels(values=[9, 8, 8, 7, 6], labels=[0, 0, 0, 1, 1], numWanted=3, useLimit=1))
