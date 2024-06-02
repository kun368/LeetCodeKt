from utils.python.predef import *


class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        MB = max(i.bit_length() for i in nums)

        pos_rz = []
        for i in range(MB):
            cur = []
            for j in nums:
                cur.append(1 if j & (1 << i) else 0)

            rz = [0] * len(cur)
            rz[-1] = -1
            for j in range(len(cur) - 2, -1, -1):
                rz[j] = j + 1 if cur[j + 1] == 0 else rz[j + 1]
            pos_rz.append(rz)

        ans = inf
        for st, stv in enumerate(nums):
            rzs = defaultdict(list)  # pos -> bits
            for i in range(MB):
                if (stv & (1 << i)) and (pos := pos_rz[i][st]) != -1:
                    rzs[pos].append(i)

            ans = min(ans, abs(k - stv))
            for pos in sorted(rzs.keys()):
                for i in rzs[pos]:
                    stv = stv ^ (1 << i)
                ans = min(ans, abs(k - stv))
        return ans


if __name__ == '__main__':
    print(Solution().minimumDifference(nums=[1, 2, 4, 5], k=3))
    print(Solution().minimumDifference(nums=[1, 2, 1, 2], k=2))
    print(Solution().minimumDifference(nums=[1], k=10))
    print(Solution().minimumDifference(nums=[1, 50, 16, 90, 59], k=40))  # 10
    print(Solution().minimumDifference(nums=[3, 1, 81, 17, 14], k=57))  # 24
