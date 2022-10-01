from utils.python.predef import *


class Solution:
    def parse(self, s):
        ds = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        m, d = str(s).split('-')
        m, d = int(m), int(d)
        return sum(ds[:m - 1]) + d

    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        a, b = self.parse(arriveAlice), self.parse(leaveAlice)
        c, d = self.parse(arriveBob), self.parse(leaveBob)
        return max(0, min(b, d) - max(a, c) + 1)


if __name__ == '__main__':
    print(Solution().countDaysTogether(arriveAlice="08-15", leaveAlice="08-18", arriveBob="08-16", leaveBob="08-19"))
    print(Solution().countDaysTogether(arriveAlice="10-01", leaveAlice="10-31", arriveBob="11-01", leaveBob="12-31"))
