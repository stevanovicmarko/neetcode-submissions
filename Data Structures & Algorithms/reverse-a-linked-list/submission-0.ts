/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     * @return {ListNode}
     */
    reverseList(head: ListNode | null): ListNode {
        let current = head;
        let previous = null;
        while (head) {
            head = head.next;
            current.next = previous;
            previous = current;
            current = head;
        }
        return previous;
    }
}
