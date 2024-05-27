from utils.python.predef import *


def rand7() -> int:
    return random.randint(1, 7)


class Solution:
    def rand10(self):
        while True:
            cur = (rand7() - 1) * 7 + (rand7() - 1)
            if cur < 40:
                return (cur % 10) + 1


if __name__ == '__main__':
    # a = [rand7() for i in range(100000)]
    a = [Solution().rand10() for i in range(1000000)]
    print(Counter(a))
