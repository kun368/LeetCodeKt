from utils.python.predef import *


class Solution:
    def maximumTotalDamage(self, power: List[int]) -> int:
        a = Counter(power)
        n = len(a)
        ks = sorted(a.keys())
        vs = [a[k] for k in ks]
        # ic(ks, vs)

        @cache
        def dfs(idx, use):
            if idx < 0:
                return 0
            ans = 0
            if use:
                cur = ks[idx] * vs[idx]
                ans = max(ans, cur)
                for j in range(idx - 1, idx - 4, -1):
                    if j >= 0 and ks[idx] - ks[j] > 2:
                        ans = max(ans, cur + dfs(j, True))
                        ans = max(ans, cur + dfs(j, False))
            else:
                ans = max(ans, dfs(idx - 1, True))
                ans = max(ans, dfs(idx - 1, False))
            return ans

        return max(dfs(n - 1, True), dfs(n - 1, False))


if __name__ == '__main__':
    print(Solution().maximumTotalDamage(power=[1, 1, 3, 4]))
    print(Solution().maximumTotalDamage(power=[7, 1, 6, 6]))
