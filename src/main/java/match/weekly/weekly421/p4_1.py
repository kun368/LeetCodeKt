from utils.python.predef import *


class Solution:
    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        MOD = int(10 ** 9 + 7)
        counter = [0] * 26
        for c in s:
            counter[ord(c) - 97] += 1

        @cache
        def take(idx, layers):
            if layers == 1:
                ret = [0] * 26
                for d in range(1, nums[idx] + 1):
                    ret[(idx + d) % 26] += 1
                return ret

            sq = max(1, layers // 2)
            ret = [0] * 26
            base = take(idx, sq)
            for i, aa in enumerate(base):
                bb = take(i, layers - sq)
                for j in range(26):
                    ret[j] = (ret[j] + aa * bb[j]) % MOD
            return ret

        ans = 0
        for i in range(26):
            ans = (ans + counter[i] * sum(take(i, t))) % MOD
        return ans


if __name__ == '__main__':
    print(Solution().lengthAfterTransformations(
        s="abcyy", t=2,
        nums=[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2]
    ))
    print(Solution().lengthAfterTransformations(
        s="azbk", t=1,
        nums=[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
    ))
    print(Solution().lengthAfterTransformations(
        s="u", t=5,
        nums=[1, 1, 2, 2, 3, 1, 2, 2, 1, 2, 3, 1, 2, 2, 2, 2, 3, 3, 3, 2, 3, 2, 3, 2, 2, 3]
    ))  # 55
    print(Solution().lengthAfterTransformations(
        s="azbk", t=int(1e9),
        nums=[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
    ))
