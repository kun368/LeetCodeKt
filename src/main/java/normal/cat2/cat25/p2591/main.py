class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if money < children:
            return -1
        for i in range(children, 0, -1):
            rest = money - i * 8
            if rest < 0: continue
            if rest > 0 and i == children: continue
            if rest == 4 and i == children - 1: continue
            if rest < children - i: continue
            return i
        return 0


if __name__ == '__main__':
    print(Solution().distMoney(money=20, children=3))  # 1
    print(Solution().distMoney(money=16, children=2))  # 2
    print(Solution().distMoney(money=17, children=2))  # 1
