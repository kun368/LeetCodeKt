from utils.python.predef import *


class Solution:
    def stringSequence(self, target: str) -> List[str]:
        cur = []
        ret = []
        for i, v in enumerate(target):
            for x in range(ord('a'), ord(v) + 1):
                ret.append(''.join(cur) + chr(x))
            cur.append(v)
        return ret


if __name__ == '__main__':
    print(Solution().stringSequence('abc'))
    print(Solution().stringSequence('he'))
