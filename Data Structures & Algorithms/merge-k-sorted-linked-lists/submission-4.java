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
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (ListNode list: lists) {
            ListNode node = list;
            while (node != null) {
                pq.offer(node.val);
                node = node.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        ListNode n = new ListNode();
        ListNode result = n;
        n.val = pq.poll();

        while (pq.isEmpty() == false) {
            n.next = new ListNode();
            n = n.next;
            n.val = pq.poll();
        }
        //n.next = null;
        return result;
    }
}