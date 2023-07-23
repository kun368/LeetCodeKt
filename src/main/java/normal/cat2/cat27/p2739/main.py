from utils.python.predef import *


class Solution:
    def distanceTraveled(self, mainTank: int, additionalTank: int) -> int:
        dis = 0
        while mainTank > 0:
            use = min(mainTank, 5)
            dis += use * 10
            mainTank -= use
            if use == 5 and additionalTank > 0:
                additionalTank -= 1
                mainTank += 1
        return dis


if __name__ == '__main__':
    print(Solution().distanceTraveled(mainTank=5, additionalTank=10))
    print(Solution().distanceTraveled(mainTank=1, additionalTank=2))
    print(Solution().distanceTraveled(mainTank=100, additionalTank=2))
