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

      PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);

      //first node of every list
      for(ListNode node : lists){
        if(node != null){
            minHeap.offer(node);
        }
      }


      ListNode dummy = new ListNode(0);
      ListNode current = dummy;


      //keep taking smallest
      while(!minHeap.isEmpty()){

        ListNode smallest = minHeap.poll();

        //add to answere
        current.next = smallest;
        current = current.next;


          // Add next node from same list
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
      }
       

       return dummy.next;



    }
}
