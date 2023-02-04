class Solution:
    def monkeyMove(self, n: int) -> int:
        mod = int(1e9 + 7)
        res = pow(2, n, mod)
        return (res - 2 + mod) % mod


if __name__ == '__main__':
    print(Solution().monkeyMove(n=3))
    print(Solution().monkeyMove(n=4))
    print(Solution().monkeyMove(n=int(1e8)))
    print(Solution().monkeyMove(n=int(1e9)))
