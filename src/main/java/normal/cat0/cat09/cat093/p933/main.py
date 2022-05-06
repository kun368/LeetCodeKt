from collections import deque


class RecentCounter:

    def __init__(self):
        self.history = deque()

    def ping(self, t: int) -> int:
        self.history.append(t)
        while self.history[-1] - self.history[0] > 3000:
            self.history.popleft()
        return len(self.history)
