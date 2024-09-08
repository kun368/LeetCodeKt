from utils.python.predef import *


class Solution:
    def convertDateToBinary(self, date: str) -> str:
        year = int(date[:4])
        month = int(date[5:7])
        day = int(date[8:])

        year_bin = bin(year)[2:]
        month_bin = bin(month)[2:]
        day_bin = bin(day)[2:]

        result = f"{year_bin}-{month_bin}-{day_bin}"
        return result


if __name__ == '__main__':
    print(Solution().convertDateToBinary(date="2080-02-29"))
    print(Solution().convertDateToBinary(date="1900-01-01"))
