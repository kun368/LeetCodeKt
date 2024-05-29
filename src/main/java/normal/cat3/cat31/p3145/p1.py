from utils.python.predef import *


class Solution:
    def query(self, pos):
        def get_one_count(t):
            t = t + 1
            ans = []
            for i in range(60):
                md = 1 << i
                a, b = t // md, t % md
                ans.append((a // 2) * md + (b if a % 2 == 1 else 0))
            return ans

        number = bisect_left(range(pos + 3), True, key=lambda x: sum(get_one_count(x)) >= pos)
        ans = get_one_count(number - 1)
        acc = sum(ans)
        bit = 0
        while acc < pos:
            if number & (1 << bit):
                acc += 1
                ans[bit] += 1
            bit += 1
        return ans

    def findProductsOfElements(self, queries: List[List[int]]) -> List[int]:
        ret = []
        for fr, to, mod in queries:
            a1 = self.query(fr)
            a2 = self.query(to + 1)
            ans = 1
            for idx, (b1, b2) in enumerate(zip(a1, a2)):
                if b2 - b1:
                    ans = (ans * pow(pow(2, idx, mod), b2 - b1, mod)) % mod
            ret.append(ans)
        return ret


if __name__ == '__main__':
    print(Solution().findProductsOfElements(queries=[[1, 3, 7]]))
    print(Solution().findProductsOfElements(queries=[[2, 5, 3], [7, 7, 4]]))
    print(Solution().findProductsOfElements(queries=[[0, 1000000000000000, 1301]]))
