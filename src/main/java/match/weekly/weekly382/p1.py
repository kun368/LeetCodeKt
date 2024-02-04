from utils.python.predef import *


class Solution:
    def countKeyChanges(self, s: str) -> int:
        if not s:
            return 0

        changes = 0
        current_key = s[0].lower()

        for char in s[1:]:
            if char.lower() != current_key:
                changes += 1
                current_key = char.lower()

        return changes


if __name__ == '__main__':
    print(Solution().countKeyChanges(s="aAbBcC"))
    print(Solution().countKeyChanges(s="AaAaAaaA"))
