from typing import *


# class Solution:
#     def largestGoodInteger(self, num: str) -> str:
#         return max([t for i in range(len(num) - 2) if len(set((t := num[i:i + 3]))) == 1], default='')


class Solution:
    def largestGoodInteger(self, num: str) -> str:
        for i in reversed(range(10)):
            if (t := str(i) * 3) in num:
                return t
        return ''


if __name__ == '__main__':
    print(Solution().largestGoodInteger('6777133339'))
    print(Solution().largestGoodInteger('2300019'))
    print(Solution().largestGoodInteger('42352338'))
    print(Solution().largestGoodInteger('222'))
