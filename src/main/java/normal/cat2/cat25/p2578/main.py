class Solution:
    def splitNum(self, num: int) -> int:
        a, b = 0, 0
        for idx, v in enumerate(sorted(str(num))):
            if idx % 2 == 0:
                a = a * 10 + int(v)
            else:
                b = b * 10 + int(v)
        return a + b


if __name__ == '__main__':
    print(Solution().splitNum(num=4325))
    print(Solution().splitNum(num=687))
