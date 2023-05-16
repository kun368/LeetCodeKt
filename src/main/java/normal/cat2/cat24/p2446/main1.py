from utils.python.predef import *


class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        (a, b), (c, d) = event1, event2
        return a <= c <= b or a <= d <= b or c <= a <= d or c <= b <= d


if __name__ == '__main__':
    print(Solution().haveConflict(event1=["01:15", "02:00"], event2=["02:00", "03:00"]))
    print(Solution().haveConflict(event1=["01:00", "02:00"], event2=["01:20", "03:00"]))
    print(Solution().haveConflict(event1=["10:00", "11:00"], event2=["14:00", "15:00"]))
