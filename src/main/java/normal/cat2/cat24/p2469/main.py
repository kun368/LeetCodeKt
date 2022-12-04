from utils.python.predef import *


class Solution:
    def convertTemperature(self, celsius: float) -> List[float]:
        return [celsius + 273.15, celsius * 1.80 + 32.00]


if __name__ == '__main__':
    print(Solution().convertTemperature(celsius=36.50))
    print(Solution().convertTemperature(celsius=122.11))
