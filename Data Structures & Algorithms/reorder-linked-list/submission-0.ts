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
     * @return {void}
     */
    reorderList(head: ListNode | null): void {
    if (head == null || head.next == null) {
        return;
    }

    // Find the middle point using 
    // tortoise and hare method
    let slow = head, fast = slow.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    // Split the linked list into two halves
    let node1 = head;
    let node2 = slow.next;
    slow.next = null;

    // Reverse the second half
    //node2 = reverseList(node2);
    let prev = null, curr = node2, next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    node2 = prev;

    // Merge alternate nodes
    let dummy = new ListNode();
    curr = dummy;
    while (node1 != null || node2 != null) {
        if (node1 != null) {
            curr.next = node1;
            curr = curr.next;
            node1 = node1.next;
        }

        if (node2 != null) {
            curr.next = node2;
            curr = curr.next;
            node2 = node2.next;
        }
    }

    return dummy.next;

    }
}
