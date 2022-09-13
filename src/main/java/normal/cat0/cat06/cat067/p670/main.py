class Solution:
    def maximumSwap(self, num: int) -> int:
        s = list(str(num))
        d = sorted(s, reverse=True)
        for i in range(len(s)):
            if s[i] != d[i]:
                t = str(num).rfind(d[i], i)
                s[i], s[t] = s[t], s[i]
                return int(''.join(s))
        return num


if __name__ == '__main__':
    print(Solution().maximumSwap(2736))
    print(Solution().maximumSwap(9973))
    print(Solution().maximumSwap(9))
    print(Solution().maximumSwap(98368))
    print(Solution().maximumSwap(1993))
