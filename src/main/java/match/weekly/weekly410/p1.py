from utils.python.predef import *


class Solution:
    def finalPositionOfSnake(self, n: int, commands: List[str]) -> int:
        row, col = 0, 0
        for command in commands:
            if command == "UP":
                row -= 1
            elif command == "DOWN":
                row += 1
            elif command == "LEFT":
                col -= 1
            elif command == "RIGHT":
                col += 1
        return row * n + col


if __name__ == '__main__':
    pass
