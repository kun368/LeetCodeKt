from utils.python.predef import *


class Solution:
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        return event2[1] >= event1[0] and event2[0] <= event1[1]


if __name__ == '__main__':
    print(Solution().haveConflict(event1=["01:15", "02:00"], event2=["02:00", "03:00"]))
    print(Solution().haveConflict(event1=["01:00", "02:00"], event2=["01:20", "03:00"]))
    print(Solution().haveConflict(event1=["10:00", "11:00"], event2=["14:00", "15:00"]))
