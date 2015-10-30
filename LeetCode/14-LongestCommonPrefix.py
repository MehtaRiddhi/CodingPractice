__author__ = 'andriicherniak'

class Solution(object):
    def longestCommonPrefix(self, strs):
        def helper(prefix, strs):

            if prefix == "":
                return ""

            str = strs[0]
            l1 = len(prefix)
            l2 = len(str)
            L = min(l1, l2)

            prefix_id = 0
            mismatch = False
            while prefix_id < L and not mismatch:
                if prefix[prefix_id] == str[prefix_id]:
                    prefix_id = prefix_id + 1
                else:
                    mismatch = True
            if prefix_id == 0:
                prefix = ""
            else:
                prefix = prefix[0:prefix_id]

            if len(strs) > 1:
                return helper(prefix, strs[1:])
            else:
                return prefix

        if not strs:
            return ""
        if len(strs) == 1:
            return strs[0]

        return helper(strs[0], strs[1:])



if __name__ == "__main__":
    print("ok")
    strs = ["aaabc", "bc", "abbb", "aaaaa"]
    print(Solution().longestCommonPrefix(strs))