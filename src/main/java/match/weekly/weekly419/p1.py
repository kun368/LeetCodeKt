from utils.python.predef import *


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        n = len(nums)
        answer = []
        for i in range(n - k + 1):
            subarray = nums[i:i + k]
            freq = Counter(subarray)
            common_elements = sorted(freq.items(), key=lambda item: (-item[1], -item[0]))[:x]
            x_sum = sum(val * cnt for val, cnt in common_elements)
            answer.append(x_sum)
        return answer


if __name__ == '__main__':
    print(Solution().findXSum(nums=[1, 1, 2, 2, 3, 4, 2, 3], k=6, x=2))
    print(Solution().findXSum(nums=[3, 8, 7, 8, 7, 5], k=2, x=2))
