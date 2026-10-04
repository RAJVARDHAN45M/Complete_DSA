/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to anchor the result list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Loop as long as there's a node in l1, l2, or a remaining carry to append
        while (l1 != null || l2 != null || carry != 0) {
            // Extract the value if the node exists, otherwise treat it as 0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate total sum for the current column
            int totalSum = val1 + val2 + carry;

            // Compute the new carry and the single-digit value for the node
            carry = totalSum / 10;
            current.next = new ListNode(totalSum % 10);

            // Advance the result pointer
            current = current.next;

            // Advance input list pointers if they aren't null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the actual head of our summed list
        return dummyHead.next;
    }
}
