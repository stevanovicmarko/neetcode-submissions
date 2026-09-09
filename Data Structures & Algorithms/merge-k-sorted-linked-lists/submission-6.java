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
        Queue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            // 1. poll the smallest node
            ListNode smallest = pq.poll();
            // 2. append it to tail, then advance tail
            tail.next = smallest;
            tail = tail.next;
            // 3. if that node has a next, offer it to the heap
            if (smallest.next != null) {
                pq.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}