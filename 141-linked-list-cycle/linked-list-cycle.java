public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        if(head.next==null){
            return false;
        }
        ListNode temp=head;
        ListNode temp2=head.next;
        while(temp2!=null && temp2.next!=null){
            if(temp==temp2){
                return true;
            }
                temp2=temp2.next.next;
                temp=temp.next;
            
        }
        return false;
    }
}