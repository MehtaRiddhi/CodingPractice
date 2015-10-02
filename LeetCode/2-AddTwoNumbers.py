__author__ = 'andriicherniak'

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def show_list(l):
    li = l
    while li != None:
        print(li.val)
        li = li.next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        if l1 == None:
            return l2

        if l2 == None:
            return l1

        l1i = l1
        l2i = l2

        result = None
        prev_node = None
        overflow = 0

        while l1i != None and l2i != None:
            vv = l1i.val + l2i.val + overflow
            overflow = 0
            if vv >= 10:
                overflow = 1
            n = ListNode(vv % 10)
            if result == None:
                result = n
            if prev_node != None:
                prev_node.next = n
            prev_node = n

            l1i = l1i.next
            l2i = l2i.next


        lli = l1i
        if lli == None:
            lli = l2i

        while lli != None:
            vv = lli.val + overflow
            overflow = 0
            if vv >= 10:
                overflow = 1
            n = ListNode(vv % 10)
            prev_node.next = n
            prev_node = n

            lli = lli.next

        if overflow > 0:
            n = ListNode(overflow)
            prev_node.next = n
            prev_node = n
            overflow = 0

        return result

if __name__ == "__main__":
    n11 = ListNode(1)
    n12 = ListNode(8)

    n21 = ListNode(0)

    l1 = n11
    n11.next = n12

    l2 = n21

    rr = Solution().addTwoNumbers(l1, l2)
    show_list(rr)
