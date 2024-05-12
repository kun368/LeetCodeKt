from utils.python.predef import *


class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        ans = -inf
        for rk in range(k):
            s = 0
            for idx in reversed(range(rk, len(energy), k)):
                s += energy[idx]
                ans = max(ans, s)
        return ans


if __name__ == '__main__':
    print(Solution().maximumEnergy(energy=[5, 2, -10, -5, 1], k=3))
    print(Solution().maximumEnergy(energy=[-2, -3, -1], k=2))
    print(Solution().maximumEnergy(energy=[-2, -3, -1], k=1))
