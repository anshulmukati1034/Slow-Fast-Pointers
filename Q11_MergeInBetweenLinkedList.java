

public class Q11_MergeInBetweenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }       
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        // Step 1: Find prevA (node before index a)
        ListNode prevA = list1;
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        // Step 2: Find afterB (node after index b)
        ListNode afterB = prevA;
        for (int i = 0; i < (b - a + 2); i++) {
            afterB = afterB.next;
        }

        // Step 3: Attach prevA → list2
        prevA.next = list2;

        // Step 4: Find tail of list2
        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Step 5: Attach tail → afterB
        tail.next = afterB;

        return list1;
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);

        int a = 3;
        int b = 4;

        ListNode mergedList = mergeInBetween(list1, a, b, list2);

        // Print merged list
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
