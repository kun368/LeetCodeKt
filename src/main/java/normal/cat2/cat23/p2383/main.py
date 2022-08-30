from utils.python.predef import *


class Solution:
    def minNumberOfHours(self,
                         initialEnergy: int,
                         initialExperience: int,
                         energy: List[int],
                         experience: List[int]) -> int:
        need = 0
        for i in energy:
            if initialEnergy > i:
                initialEnergy -= i
            else:
                need += i + 1 - initialEnergy
                initialEnergy = 1
        for i in experience:
            if initialExperience > i:
                initialExperience += i
            else:
                need += i + 1 - initialExperience
                initialExperience = i + 1 + i
        return need


if __name__ == '__main__':
    print(Solution().minNumberOfHours(
        initialEnergy=5,
        initialExperience=3,
        energy=[1, 4, 3, 2],
        experience=[2, 6, 3, 1]))
    print(Solution().minNumberOfHours(
        initialEnergy=2,
        initialExperience=4,
        energy=[1],
        experience=[3]))
