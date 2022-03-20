class Solution:
    def minSteps(self, s: str, t: str) -> int:
        from collections import Counter
        ss, tt = Counter(s), Counter(t)
        return sum((ss - tt).values()) + sum((tt - ss).values())


if __name__ == '__main__':
    print(Solution().minSteps('leetcode', 'coats'))
    print(Solution().minSteps('night', 'thing'))
    print(Solution().minSteps('cotxazilut', 'nahrrmcchxwrieqqdwdpneitkxgnt'))
