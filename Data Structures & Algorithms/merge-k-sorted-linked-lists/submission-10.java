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
    public ListNode mergeKLists(ListNode[] lists) {
        var pq = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        for (var list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        var result = new ListNode();
        var tail = result;
        while (!pq.isEmpty()) {
            var node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            tail.next = node;
            tail = tail.next;
        }

        return result.next;
    }
}
