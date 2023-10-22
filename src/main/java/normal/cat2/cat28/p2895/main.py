from utils.python.predef import *


class Solution:
    def minProcessingTime(self, processorTime: List[int], tasks: List[int]) -> int:
        processorTime.sort()
        tasks.sort(reverse=True)
        return max(processorTime[i] + tasks[i * 4] for i in range(len(processorTime)))


if __name__ == '__main__':
    print(Solution().minProcessingTime(processorTime=[8, 10], tasks=[2, 2, 3, 1, 8, 7, 4, 5]))
    print(Solution().minProcessingTime(processorTime=[10, 20], tasks=[2, 3, 1, 2, 5, 8, 4, 3]))
