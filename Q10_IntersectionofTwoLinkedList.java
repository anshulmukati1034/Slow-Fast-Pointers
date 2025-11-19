
public class Q10_IntersectionofTwoLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }   
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null && headB == null){
            return null;
        }

        ListNode tail = headA;

        while(tail.next != null){
            tail = tail.next; 
        }

        tail.next = headB;

        ListNode slow = headA;
        ListNode fast = headA;

        boolean hasCycle = false;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;


            if(slow == fast){
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            tail.next = null; 
            return null;
        }

        slow = headA;
        while(slow !=fast){
           
            slow=slow.next;
            fast = fast.next;
            
        }
        

        tail.next = null; 

        return slow;


    }

    public static void main(String[] args) {
        // Example usage:
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        headA.next.next = intersection;
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        ListNode result = getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
