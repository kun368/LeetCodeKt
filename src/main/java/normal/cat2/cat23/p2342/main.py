from utils.python.predef import *


class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        from collections import defaultdict
        import heapq

        eq_dict = defaultdict(list)
        for i in nums:
            eq_dict[sum(int(j) for j in str(i))].append(i)
        ret = -1
        for i in eq_dict.values():
            if len(i) >= 2:
                ret = max(ret, sum(heapq.nlargest(2, i)))
        return ret


if __name__ == '__main__':
    print(Solution().maximumSum(nums=[18, 43, 36, 13, 7]))
    print(Solution().maximumSum(nums=[10, 12, 19, 14]))
