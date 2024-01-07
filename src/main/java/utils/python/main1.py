from utils.python.predef import *

mod = 1000000007


def divMod(a, b):
    return (a * pow(b, mod - 2, mod)) % mod


class Solution:
    def canMakePalindromeQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        n = len(s)
        print(s[:n//2])
        print(s[n//2:][::-1])
        pri = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]

        mul = [1] * (len(s) + 1)
        for i in range(len(s)):
            mul[i] = (mul[i - 1] * pri[ord(s[i]) - ord('a')]) % mod

        def get_mul(a, b):
            print([a, b], divMod(mul[b], mul[a - 1]))
            return divMod(mul[b], mul[a - 1])

        def check_eq(a, b):
            if a > b:
                return True
            return get_mul(a, b) == get_mul(n - b - 1, n - a - 1)

        ans = []
        for a, b, c, d in queries:
            b2 = n - c - 1
            a2 = n - d - 1
            print([a, b], [a2, b2])
            cur = True
            if not check_eq(0, n // 2 - 1):
                cur = False
            if not check_eq(0, min(a, a2) - 1):
                cur = False
            if not check_eq(max(b, b2) + 1, n // 2 - 1):
                cur = False
            if not check_eq(min(a, a2), max(b, b2)):
                cur = False
            if check_eq(max(a, a2), min(b, b2)):
                if not check_eq(min(a, a2), max(a, a2) - 1):
                    cur = False
            # print([a, b, c, d], cur)
            ans.append(cur)
        return ans


if __name__ == '__main__':
    # print(Solution().canMakePalindromeQueries(s="abcabc", queries=[[1, 1, 3, 5], [0, 2, 5, 5]]))
    # print(Solution().canMakePalindromeQueries(s="abbcdecbba", queries=[[0, 2, 7, 9]]))
    # print(Solution().canMakePalindromeQueries(s="acbcab", queries=[[1, 2, 4, 5]]))
    print(Solution().canMakePalindromeQueries(s="odaxusaweuasuoeudxwa", queries=[[0, 5, 10, 14]]))  # true
