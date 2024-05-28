from utils.python.predef import *


class ProductOfNumbers:
    def __init__(self):
        self.acc = [1]
        self.mark = -1

    def add(self, num: int) -> None:
        if num == 0:
            self.mark = len(self.acc)
        self.acc.append(self.acc[-1] * max(1, num))

    def getProduct(self, k: int) -> int:
        if len(self.acc) - k <= self.mark:
            return 0
        return self.acc[-1] // self.acc[-k - 1]


if __name__ == '__main__':
    productOfNumbers = ProductOfNumbers()
    productOfNumbers.add(3)  # [3]
    productOfNumbers.add(0)  # [3,0]
    productOfNumbers.add(2)  # [3,0,2]
    productOfNumbers.add(5)  # [3,0,2,5]
    productOfNumbers.add(4)  # [3,0,2,5,4]
    print(productOfNumbers.getProduct(2))  # 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
    print(productOfNumbers.getProduct(3))  # 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
    print(productOfNumbers.getProduct(4))  # 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
    productOfNumbers.add(8)  # [3,0,2,5,4,8]
    print(productOfNumbers.getProduct(2))  # 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
