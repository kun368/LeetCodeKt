from utils.python.predef import *


class Solution:
    def findLatestTime(self, s: str) -> str:
        expr = re.compile(s.replace('?', '.'))
        for i in reversed(range(12)):
            for j in reversed(range(60)):
                cur = f'{i:02}:{j:02}'
                mt = re.match(expr, cur)
                if mt:
                    return cur
        return None


if __name__ == '__main__':
    print(Solution().findLatestTime(s="1?:?4"))
    print(Solution().findLatestTime(s="0?:5?"))
