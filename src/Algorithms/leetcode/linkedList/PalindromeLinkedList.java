package Algorithms.leetcode.linkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            if (fast.next!= null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        ListNode reverseNode = reverseList(slow);

        while (reverseNode != null && head != null) {
            if (reverseNode.val == head.val) {
                reverseNode = reverseNode.next;
                head = head.next;
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode current = node;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }
        return pre;
    }

}
