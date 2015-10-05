__author__ = 'andriicherniak'

class Solution(object):
    def isPalindrome(self, x):
        if x < 0:
            return False
        if x == 0:
            return True
        div = 1
        while x / div >= 10:
            div *= 10

        while x != 0:
            left = x / div
            right = x % 10

            if left != right:
                return False

            x = (x % div ) / 10
            div /= 100

        return True


if __name__ == "__main__":
    print(Solution().isPalindrome(10))