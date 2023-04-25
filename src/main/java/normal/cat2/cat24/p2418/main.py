from utils.python.predef import *


class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        return [a for a, b in sorted(zip(names, heights), key=lambda x: -x[1])]


if __name__ == '__main__':
    print(Solution().sortPeople(
        names=["Mary", "John", "Emma"], heights=[180, 165, 170]))
    print(Solution().sortPeople(
        names=["Alice", "Bob", "Bob"], heights=[155, 185, 150]))
