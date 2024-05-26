from utils.python.predef import *


class Solution:
    def compressedString(self, word: str) -> str:
        ans = []
        for a, b in groupby(word):
            b = len(list(b))
            while b:
                cur = min(b, 9)
                ans.append(str(cur))
                ans.append(a)
                b -= cur
        return ''.join(ans)


if __name__ == '__main__':
    print(Solution().compressedString(word="abcde"))
    print(Solution().compressedString(word="aaaaaaaaaaaaaabb"))
