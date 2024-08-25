from utils.python.predef import *

MOD = int(1e9 + 7)


class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        from sortedcontainers import SortedList

        if multiplier == 1:
            return nums

        ls = SortedList()
        for idx, v in enumerate(nums):
            ls.add([v, idx])

        while k > 0:
            v, idx = ls.pop(0)
            v *= multiplier
            ls.add([v, idx])
            k -= 1
            if ls[0][0] * multiplier > ls[-1][0]:
                break

        ls = list(ls)
        for ii, (v, idx) in enumerate(ls):
            t = k // len(ls) + (1 if k % len(ls) > ii else 0)
            ls[ii] = [v * pow(multiplier, t, MOD), idx]
        ans = sorted(ls, key=lambda x: x[1])
        return [x[0] % MOD for x in ans]


if __name__ == '__main__':
    # print(Solution().getFinalState(nums=[2, 1, 3, 5, 6], k=5, multiplier=1))
    # print(Solution().getFinalState(nums=[2, 1, 3, 5, 6], k=5, multiplier=2))
    # print(Solution().getFinalState(nums=[1, 2], k=3, multiplier=4))
    # print(Solution().getFinalState(nums=[100000, 2000], k=2, multiplier=1000000))
    print(Solution().getFinalState(
        [3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721,
         129140163, 387420489], 1000000000, 3))
