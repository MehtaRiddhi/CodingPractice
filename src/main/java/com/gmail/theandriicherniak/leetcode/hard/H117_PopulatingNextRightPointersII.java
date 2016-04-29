package com.gmail.theandriicherniak.leetcode.hard;

/**
 * Created by andriicherniak on 4/28/16.
 */
public class H117_PopulatingNextRightPointersII {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode nextRowHead = null;
        TreeLinkNode nextRowCur = null;


        while (cur != null){
            nextRowHead = new TreeLinkNode(0);
            nextRowCur = nextRowHead;

            while (cur != null){
                if (cur.left != null){
                    nextRowCur.next = cur.left;
                    nextRowCur = cur.left;
                }
                if (cur.right != null){
                    nextRowCur.next = cur.right;
                    nextRowCur = cur.right;
                }
                cur = cur.next;
            }
            cur = nextRowHead.next;
        }

    }
}
