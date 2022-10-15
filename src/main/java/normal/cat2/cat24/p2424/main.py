class LUPrefix:
    def __init__(self, n: int):
        self.up = [False] * (n + 5)
        self.lo = 0

    def upload(self, video: int) -> None:
        self.up[video] = True

    def longest(self) -> int:
        while self.up[self.lo + 1]:
            self.lo += 1
        return self.lo
