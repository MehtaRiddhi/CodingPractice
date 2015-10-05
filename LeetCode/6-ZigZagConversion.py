__author__ = 'andriicherniak'

class Solution(object):
    def convert(self, s, numRows):

        class zigzag:
            def __init__(self, n_init):
                self.n = n_init
                self.row = 0
                self.direction = 1

            def next(self):
                self.row += self.direction
                if self.row == self.n:
                    self.direction = -1
                if self.direction == -1 and self.row == 1:
                    self.direction = 1
                return self.row

        if numRows == 1:
            return s

        r = zigzag(numRows)
        zigzag_result = {}
        result = []

        for ch in s:
            row = r.next()
            print(ch + " " + str(row))

            if row not in zigzag_result:
                zigzag_result[row] = []
            zigzag_result[row].append(ch)

        for row in range(1, numRows + 1):
            if row in zigzag_result:
                result.append(''.join(zigzag_result[row]))

        return ''.join(result)

if __name__ == "__main__":
    print(Solution().convert("AB", 1))