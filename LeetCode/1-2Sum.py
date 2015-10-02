__author__ = 'andriicherniak'

class Solution(object):
    def twoSum(self, nums, target):
        num_index = {}
        result = []
        resultFound = False

        for id, v in enumerate(nums):
            if v not in num_index:
                num_index[v] = []

            num_index[v].append(id + 1)

        it = iter(nums)
        while not resultFound:
            v = it.__next__()
            v_id = num_index[v][0]
            diff = target - v

            if diff != v and diff in num_index:
                result.append(num_index[diff][0])
                result.append(v_id)
                resultFound = True

            if diff == v and diff in num_index and len(num_index[diff]) >= 2:
                result.append(num_index[diff][0])
                result.append(num_index[diff][1])
                resultFound = True

        return [el for el in sorted(result)]


if __name__ == "__main__":
    print(Solution().twoSum([0,4,3,0], 0))