class Solution:
    def countDigits(self, num: int) -> int:
        return len([1 for i in str(num) if num % int(i) == 0])


if __name__ == '__main__':
    pass
