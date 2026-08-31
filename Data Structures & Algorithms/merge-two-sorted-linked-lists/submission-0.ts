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
     * @param {ListNode} list1
     * @param {ListNode} list2
     * @return {ListNode}
     */

    sortedMerge(head1: ListNode, head2: ListNode): ListNode  {

    // base cases
    if (head1 === null)
        return head2;
    if (head2 === null)
        return head1;

    // recursive merging based on smaller value
    if (head1.val <= head2.val) {
        head1.next = this.sortedMerge(head1.next, head2);
        return head1;
    }
    else {
        head2.next = this.sortedMerge(head1, head2.next);
        return head2;
    }
}
    mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode {
        return this.sortedMerge(list1, list2);
    }
}
