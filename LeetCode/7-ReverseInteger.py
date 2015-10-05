__author__ = 'andriicherniak'

class Solution(object):
    def reverse(self, x):
        result = int(str(abs(x))[::-1])
        if (result > 0x7fffffff):
            return 0
        if x < 0:
            result *= -1

        return result


if __name__ == "__main__":
    print(Solution().reverse(-123))