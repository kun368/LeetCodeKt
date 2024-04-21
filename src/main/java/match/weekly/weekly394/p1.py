from utils.python.predef import *

class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        st = set(word)
        ans = 0
        for i in string.ascii_lowercase:
            if i in st and str(i).upper() in st:
                ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().numberOfSpecialChars(word="aaAbcBC"))
    print(Solution().numberOfSpecialChars(word="abc"))
    print(Solution().numberOfSpecialChars(word="abBCab"))