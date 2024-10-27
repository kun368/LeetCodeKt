from utils.python.predef import *

import numpy as np
from numpy.typing import NDArray

MOD = int(10 ** 9 + 7)


def new_mat(a: List[List[int]]):
    return np.array(a, dtype=np.object_)  # avoid overflowing int


def mat_mul(a: NDArray, b: NDArray) -> NDArray:
    return a.dot(b) % MOD


def mat_pow(a: NDArray, n: int) -> NDArray:
    z = result = None
    while n > 0:
        z = a if z is None else mat_mul(z, z)
        n, bit = divmod(n, 2)
        if bit:
            result = z if result is None else mat_mul(result, z)
    return result


class Solution:
    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        counter = [0] * 26
        for c in s:
            counter[ord(c) - 97] += 1
        counter = np.array(counter, dtype=np.object_)

        mapper = []
        for i in range(26):
            cur = [0] * 26
            for j in range(i + 1, i + nums[i] + 1):
                cur[j % 26] = 1
            mapper.append(cur)
        mapper = np.array(mapper, dtype=np.object_)

        res = mat_mul(counter, mat_pow(mapper, t))
        return res.sum() % MOD


if __name__ == '__main__':
    print(Solution().lengthAfterTransformations(
        s="abcyy", t=2,
        nums=[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2]
    ))
    print(Solution().lengthAfterTransformations(
        s="azbk", t=1,
        nums=[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
    ))
    print(Solution().lengthAfterTransformations(
        s="u", t=5,
        nums=[1, 1, 2, 2, 3, 1, 2, 2, 1, 2, 3, 1, 2, 2, 2, 2, 3, 3, 3, 2, 3, 2, 3, 2, 2, 3]
    ))  # 55
    print(Solution().lengthAfterTransformations(
        s="mppgvcssluzhipednraxbdfbyn", t=3719,
        nums=[5, 3, 8, 1, 4, 2, 2, 4, 5, 2, 8, 5, 8, 2, 6, 10, 8, 1, 4, 1, 7, 4, 2, 4, 7, 5]
    ))  # 467065288
