from utils.python.predef import *


class Solution:
    def maximumSetSize(self, nums1: List[int], nums2: List[int]) -> int:
        def solve(c1, c2, ks):
            n = len(nums1) // 2
            use1, use2 = 0, 0
            ans = 0
            for k in ks:
                if k in c1 and k not in c2 and use1 < n:
                    del c1[k]
                    use1 += 1
                    ans += 1
                    # print('c1', k)
                    continue
                if k not in c1 and k in c2 and use2 < n:
                    del c2[k]
                    use2 += 1
                    ans += 1
                    # print('c2', k)
                    continue

                if k in c1 and k in c2:
                    if use1 < n and use2 < n:
                        if use2 <= use1:
                            del c2[k]
                            use2 += 1
                            ans += 1
                            # print('c2', k)
                            continue
                        else:
                            del c1[k]
                            use1 += 1
                            ans += 1
                            # print('c1', k)
                            continue
                    if use2 < n:
                        del c2[k]
                        use2 += 1
                        ans += 1
                        # print('c2', k)
                        continue
                    if use1 < n:
                        del c1[k]
                        use1 += 1
                        ans += 1
                        # print('c1', k)
                        continue
            return ans

        ans = 0
        for i in range(10):
            c1 = Counter(nums1)
            c2 = Counter(nums2)
            ks = list(set(c1.keys()) | set(c2.keys()))
            shuffle(ks)
            ans = max(ans, solve(c1, c2, ks))

        return ans
