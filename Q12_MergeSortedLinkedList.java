public class Q12_MergeSortedLinkedList {
    
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode getMid(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private static ListNode merged(ListNode head, ListNode rightHead){
        ListNode mergeLL = new ListNode(-1);
        ListNode temp = mergeLL;

        while(head != null && rightHead != null){
            if(head.val <= rightHead.val){
                temp.next = head;
                head = head.next;
                temp = temp.next;
            }else{
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }

        while(head != null){
             temp.next = head;
            head = head.next;
            temp = temp.next;
        }

        while(rightHead != null){
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }
    

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }       

        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode newLeft = sortList(head);
        ListNode newRight = sortList(rightHead);

        return merged(newLeft, newRight);
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sortedHead = sortList(head);

        // Print sorted list
        ListNode current = sortedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
