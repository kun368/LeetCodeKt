from utils.python.predef import *


class Solution:
    def sumImbalanceNumbers(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            mp = [False] * (n + 3)
            cnt = 0
            for j in range(i, n):
                cur = nums[j]
                if not mp[cur]:
                    cnt += 1
                    if mp[cur + 1]:
                        cnt -= 1
                    if mp[cur - 1]:
                        cnt -= 1
                mp[cur] = True
                ans += cnt - 1
        return ans


if __name__ == '__main__':
    print(Solution().sumImbalanceNumbers(nums=[2, 3, 1, 4]))
    print(Solution().sumImbalanceNumbers(nums=[1, 3, 3, 3, 5]))
