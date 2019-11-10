package Algorithms.leetcode.linkedList;

/**
 * 203.
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
//1,2,2,1
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode node = head;
        while (node != null) {
            if (head.val == val) {
                head = head.next;
                node = node.next;
                continue;
            }
            if (node.val == val) {
                pre.next = node.next;
            }
            if (node.val != val) {
                pre = node;
            }
            node = node.next;
        }
        return head;
    }


}
