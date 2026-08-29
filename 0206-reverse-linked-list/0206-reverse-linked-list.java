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
    public ListNode reverseList(ListNode head) {
        
        // if(head==null || head.next==null){
        //     return head;
        // }
        
        // ListNode prev = head;
        // ListNode curr = head.next;
        // head.next = null;
        // while(curr!=null){
        //     ListNode next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }

    //     // return prev;
    //     if(head==null || head.next==null){
    //         return head;
    //     } 

    //     ListNode prev = head;
    //     ListNode curr = head.next;
    //     head.next = null;
    //     while(curr!=null){
    //         ListNode temp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = temp;
    //     }
    //     return prev;
    // }



    if(head==null || head.next==null){
        return head;
    }
    ListNode curr = head;
    ListNode temp = head.next;
    head.next=null;

    while(temp.next!=null){
        ListNode temp1 = temp.next;
        temp.next = curr;
        curr = temp;
        temp = temp1;
    }

    temp.next = curr;

    return temp;

    }
}