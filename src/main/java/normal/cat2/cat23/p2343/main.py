from utils.python.predef import *


class Solution:
    def smallestTrimmedNumbers(self, nums: List[str], queries: List[List[int]]) -> List[int]:
        ans = []
        for k, trim in queries:
            cur = [int(i[-trim:]) for i in nums]
            ans.append(sorted((cur[i], i) for i in range(len(cur)))[k - 1][1])
        return ans


if __name__ == '__main__':
    print(Solution().smallestTrimmedNumbers(
        nums=["102", "473", "251", "814"],
        queries=[[1, 1], [2, 3], [4, 2], [1, 2]]
    ))
    print(Solution().smallestTrimmedNumbers(
        nums=["24", "37", "96", "04"],
        queries=[[2, 1], [2, 2]]
    ))
