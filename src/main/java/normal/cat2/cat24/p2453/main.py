from utils.python.predef import *


class Solution:
    def destroyTargets(self, nums: List[int], space: int) -> int:
        counter = defaultdict(list)
        for i in nums:
            counter[i % space].append(i)
        max_size = max(len(i) for i in counter.values())
        return min(itertools.chain.from_iterable(i for i in counter.values() if len(i) == max_size))


if __name__ == '__main__':
    print(Solution().destroyTargets(nums=[3, 7, 8, 1, 1, 5], space=2))
    print(Solution().destroyTargets(nums=[1, 3, 5, 2, 4, 6], space=2))
    print(Solution().destroyTargets(nums=[6, 2, 5], space=100))
