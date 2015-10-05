__author__ = 'andriicherniak'

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        char_position = {}
        start = 0
        start_ch = ''

        dd = []
        if s == "":
            return 0
        else:
            start_ch = s[0]

        for num, ch in enumerate(s):
            if ch not in char_position:
                dd.append(num - start + 1)
            if ch in char_position:
                if ch != start_ch and char_position[ch] >= start:
                    dd.append(num - start)
                if ch != start_ch and char_position[ch] < start:
                    dd.append(num - start + 1)

                if char_position[ch] >= start:
                    start = char_position[ch] + 1
                    start_ch = s[start]
            char_position[ch] = num

            # print(ch + " " + str(num) + " " + str(start) + " " + start_ch)

        return max(dd)


if __name__ == "__main__":
    print(Solution().lengthOfLongestSubstring("aaa"))
