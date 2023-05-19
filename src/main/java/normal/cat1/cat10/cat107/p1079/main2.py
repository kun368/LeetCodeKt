from utils.python.predef import *


class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        def dfs(cur):
            ans = 0
            for i in range(26):
                if not cur[i]:
                    continue
                ans += 1
                cur[i] -= 1
                ans += dfs(cur)
                cur[i] += 1
            return ans

        counter = list(tiles.count(i) for i in ascii_uppercase)
        return dfs(counter)


if __name__ == '__main__':
    print(Solution().numTilePossibilities("AAB"))
    print(Solution().numTilePossibilities("AAABBC"))
    print(Solution().numTilePossibilities("V"))
