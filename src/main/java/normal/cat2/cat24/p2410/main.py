from utils.python.predef import *


class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()

        res = 0
        j = 0
        for i in players:
            while j < len(trainers) and trainers[j] < i:
                j += 1
            if j < len(trainers):
                res += 1
                j += 1
        return res


if __name__ == '__main__':
    print(Solution().matchPlayersAndTrainers(players=[4, 7, 9], trainers=[8, 2, 5, 8]))
    print(Solution().matchPlayersAndTrainers(players=[1, 1, 1], trainers=[10]))
