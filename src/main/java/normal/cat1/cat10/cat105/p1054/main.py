from utils.python.predef import *


class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        counter = Counter(barcodes)
        barcodes.sort(key=lambda x: (-counter[x], x))
        sp = len(barcodes) // 2 if len(barcodes) % 2 == 0 else len(barcodes) // 2 + 1
        a, b = barcodes[:sp], barcodes[sp:]
        ans = []
        for x, y in zip_longest(a, b, fillvalue=None):
            if x: ans.append(x)
            if y: ans.append(y)
        return ans


if __name__ == '__main__':
    print(Solution().rearrangeBarcodes(barcodes=[1, 1, 1, 2, 2, 2]))
    print(Solution().rearrangeBarcodes(barcodes=[1, 1, 1, 1, 2, 2, 3, 3]))
    print(Solution().rearrangeBarcodes(barcodes=[1, 1, 3, 3, 3]))
    print(Solution().rearrangeBarcodes(barcodes=[1]))
    print(Solution().rearrangeBarcodes(barcodes=[2, 2, 1, 3]))
    print(Solution().rearrangeBarcodes(barcodes=[2, 2, 2, 1, 5]))
    print(Solution().rearrangeBarcodes(barcodes=[7, 7, 7, 8, 5, 7, 5, 5, 5, 8]))
