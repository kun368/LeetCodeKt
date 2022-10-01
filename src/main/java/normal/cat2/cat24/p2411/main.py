from utils.python.predef import *


class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        pos = defaultdict(deque)
        for i in range(len(nums)):
            t = nums[i]
            p = 0
            while t > 0:
                if t % 2 == 1:
                    pos[p].append(i)
                p += 1
                t >>= 1

        ans = []
        for i in range(len(nums)):
            right = i + 1
            for vs in pos.values():
                if not vs:
                    continue
                right = max(right, vs[0] + 1)
                if vs[0] == i:
                    vs.popleft()
            ans.append(right - i)
        return ans


if __name__ == '__main__':
    print(Solution().smallestSubarrays([0, 0, 0]))
    print(Solution().smallestSubarrays([1, 0, 2, 1, 3]))
    print(Solution().smallestSubarrays([1, 2]))
