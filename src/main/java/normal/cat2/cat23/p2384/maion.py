from utils.python.predef import *


class Solution:
    def largestPalindromic(self, num: str) -> str:
        counter = Counter(num)
        max_single = chr(0)
        ans = []
        for i in reversed(string.digits):
            if i not in counter:
                continue
            cnt = counter[i]
            for k in range(cnt // 2):
                if i != '0' or ans:
                    ans.append(i)
            if cnt % 2 == 1:
                max_single = max(max_single, i)
        if not ans and not ord(max_single):
            return '0'
        return ''.join(ans) + (max_single if ord(max_single) else '') + ''.join(reversed(ans))


if __name__ == '__main__':
    print(Solution().largestPalindromic("444947137"))
    print(Solution().largestPalindromic("00009"))
    print(Solution().largestPalindromic("123"))
    print(Solution().largestPalindromic("112233"))
    print(Solution().largestPalindromic("0000"))
