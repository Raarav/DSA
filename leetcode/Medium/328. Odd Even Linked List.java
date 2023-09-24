Q->https://leetcode.com/problems/odd-even-linked-list/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        
        while(odd != null && odd.next != null && even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }    
        odd.next = evenHead;
        return head;
    }
}