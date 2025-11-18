
public class Q6_RemoveNthNodeFromEndofList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }   
    
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

         for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode result = removeNthFromEnd(head, n);
        
        // Print the modified list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
