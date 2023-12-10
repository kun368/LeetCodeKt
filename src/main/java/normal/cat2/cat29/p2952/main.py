from utils.python.predef import *


class Solution:
    def minimumAddedCoins(self, coins: List[int], target: int) -> int:
        counter = Counter(coins)
        keys = sorted(list(counter.keys()), reverse=True)
        if keys[-1] == 1:
            keys.pop()
            reach, ans = counter[1], 0
        else:
            reach, ans = 1, 1

        while reach < target:
            if not keys or reach < keys[-1] - 1:
                ans += 1
                reach = reach * 2 + 1
                continue
            i = keys.pop()
            reach = reach + i * counter[i]
        return ans


if __name__ == '__main__':
    print(Solution().minimumAddedCoins(coins=[1, 4, 10], target=19))
    print(Solution().minimumAddedCoins(coins=[1, 4, 10, 5, 7, 19], target=19))
    print(Solution().minimumAddedCoins(coins=[1, 1, 1], target=20))
