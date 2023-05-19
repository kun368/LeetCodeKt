from utils.python.predef import *


class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        return len(set(j for i in range(len(tiles)) for j in permutations(tiles, i + 1)))


if __name__ == '__main__':
    print(Solution().numTilePossibilities("AAB"))
    print(Solution().numTilePossibilities("AAABBC"))
    print(Solution().numTilePossibilities("V"))
