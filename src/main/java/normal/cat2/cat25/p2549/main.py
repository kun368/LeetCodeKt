class Solution:
    def distinctIntegers(self, n: int) -> int:
        s = {n}
        while True:
            cur = set(s)
            for x in s:
                for i in range(1, n + 1):
                    if x % i == 1:
                        cur.add(i)
            if cur == s:
                break
            s = cur
        return len(s)


if __name__ == '__main__':
    print(Solution().distinctIntegers(n=5))
    print(Solution().distinctIntegers(n=3))
