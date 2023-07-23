from utils.python.predef import *


class Solution:
    def continuousSubarrays(self, nums: List[int]) -> int:
        ans = 0
        right = 0
        counter = Counter()
        for left in range(len(nums)):
            while right < len(nums):
                cur = nums[right]
                ks = sorted(counter.keys())
                if len(ks) == 0 or (cur - ks[0] <= 2 and ks[-1] - cur <= 2):
                    counter.update([cur])
                    right += 1
                else:
                    break
            ans += right - left
            if counter[nums[left]] == 1:
                counter.pop(nums[left])
            else:
                counter.subtract([nums[left]])
        return ans


if __name__ == '__main__':
    print(Solution().continuousSubarrays(nums=[5, 4, 2, 4]))
    print(Solution().continuousSubarrays(nums=[1, 2, 3]))
