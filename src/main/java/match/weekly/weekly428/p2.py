from utils.python.predef import *


class Solution:
    def maxAmount(self, initialCurrency: str,
                  pairs1: List[List[str]], rates1: List[float],
                  pairs2: List[List[str]], rates2: List[float]) -> float:
        g1 = defaultdict(list)
        g2 = defaultdict(list)
        for i, (st, ed) in enumerate(pairs1):
            g1[st].append((ed, rates1[i]))
            g1[ed].append((st, 1 / rates1[i]))
        for i, (st, ed) in enumerate(pairs2):
            g2[st].append((ed, rates2[i]))
            g2[ed].append((st, 1 / rates2[i]))

        def bfs(st, g):
            qu = deque([(st, 1.0)])
            best = defaultdict(float)
            best[st] = 1.0
            while qu:
                current, amount = qu.popleft()
                for neighbor, rate in g[current]:
                    new_amount = amount * rate
                    if new_amount > best[neighbor]:
                        best[neighbor] = new_amount
                        qu.append((neighbor, new_amount))
            return best

        day1 = bfs(initialCurrency, g1)
        ans = 1.0
        for currency, amount in day1.items():
            second_day_best = bfs(currency, g2)
            for a, b in second_day_best.items():
                if a == initialCurrency:
                    ans = max(ans, b * amount)
            # ic(currency, amount, second_day_best, ans)
        return ans


if __name__ == '__main__':
    print(Solution().maxAmount(
        initialCurrency="EUR",
        pairs1=[["EUR", "USD"], ["USD", "JPY"]], rates1=[2.0, 3.0],
        pairs2=[["JPY", "USD"], ["USD", "CHF"], ["CHF", "EUR"]], rates2=[4.0, 5.0, 6.0]))
    print(Solution().maxAmount(
        initialCurrency="NGN",
        pairs1=[["NGN", "EUR"]], rates1=[9.0],
        pairs2=[["NGN", "EUR"]], rates2=[6.0]))
    print(Solution().maxAmount(
        initialCurrency="USD",
        pairs1=[["USD", "EUR"]], rates1=[1.0],
        pairs2=[["EUR", "JPY"]], rates2=[10.0]))
