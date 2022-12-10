from utils.python.predef import *


class Solution:
    def subarrayLCM(self, nums: List[int], k: int) -> int:
        from math import gcd

        ans = 0
        for i in range(len(nums)):
            t = nums[i]
            if t == k:
                ans += 1
            for j in range(i + 1, len(nums)):
                if k % nums[j] != 0:
                    break
                t = t * nums[j] // gcd(t, nums[j])
                if t == k:
                    ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().subarrayLCM(nums=[3, 6, 2, 7, 1], k=6))
    print(Solution().subarrayLCM(nums=[3], k=2))
