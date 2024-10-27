from utils.python.predef import *


class Solution:
    def numberOfSubstrings(self, s: str, k: int) -> int:
        ans = 0
        j = 1
        counter = Counter(s[0])
        for i, v in enumerate(s):
            while counter.most_common(1)[0][1] < k and j < len(s):
                counter[s[j]] += 1
                j += 1
            if counter.most_common(1)[0][1] >= k:
                ans += len(s) - j + 1
            counter[v] -= 1
        return ans


if __name__ == '__main__':
    print(Solution().numberOfSubstrings(s="abacb", k=2))
    print(Solution().numberOfSubstrings(s="abcde", k=1))
