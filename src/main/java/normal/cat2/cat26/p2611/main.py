from utils.python.predef import *


class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        a = sorted(zip(reward1, reward2), key=lambda x: x[1] - x[0])
        return sum(a if i < k else b for i, (a, b) in enumerate(a))


if __name__ == '__main__':
    print(Solution().miceAndCheese(reward1=[1, 1, 3, 4], reward2=[4, 4, 1, 1], k=2))
    print(Solution().miceAndCheese(reward1=[1, 1], reward2=[1, 1], k=2))
