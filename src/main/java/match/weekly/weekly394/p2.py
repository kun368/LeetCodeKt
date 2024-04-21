from utils.python.predef import *


class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        st = defaultdict(list)
        for idx, c in enumerate(word):
            st[c].append(idx)

        ans = 0
        for i in string.ascii_lowercase:
            a = st[i]
            b = st[str(i).upper()]
            if not a or not b:
                continue
            if a[-1] < b[0]:
                ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().numberOfSpecialChars(word="aaAbcBC"))
    print(Solution().numberOfSpecialChars(word="abc"))
    print(Solution().numberOfSpecialChars(word="AbBCab"))
