from typing import *


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        return sum(list(col) != sorted(col) for col in zip(*strs))


if __name__ == '__main__':
    print(Solution().minDeletionSize(["cba", "daf", "ghi"]))
    print(Solution().minDeletionSize(["a", "b"]))
    print(Solution().minDeletionSize(["zyx", "wvu", "tsr"]))
