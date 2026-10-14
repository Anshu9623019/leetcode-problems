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
        // if(l1.val==0){
        //     return l2;
        // }
        // if(l2.val==0){
        //     return l1;
        // }


        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;
        ListNode ans = new ListNode(-1);
        ListNode node = ans;
        while(head1!=null && head2!= null){
            int val = head1.val + head2.val + carry;
            int temp = val%10;
            carry = val/10;
            node.next = new ListNode(temp);
            node = node.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        while(head1!=null){
             int val = head1.val + carry;
             int temp = val%10;
             carry = val/10;
             node.next = new ListNode(temp);
             node = node.next;
             head1 = head1.next;
        }

        while(head2!=null){
             int val = head2.val + carry;
             int temp = val%10;
             carry = val/10;
             node.next = new ListNode(temp);
             node = node.next;
             head2 = head2.next;
        }

        if(carry!=0){
            node.next = new ListNode(carry);
        }
        return ans.next;
    }
}