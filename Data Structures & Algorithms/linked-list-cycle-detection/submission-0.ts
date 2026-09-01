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
     * @return {boolean}
     */
    hasCycle(head: ListNode | null): boolean {
        const detector = new Set<ListNode>;

        while (head) {
            if (detector.has(head)) {
                return true;
            }
            detector.add(head);
            head = head.next;
        }

        return false;
    }
}
