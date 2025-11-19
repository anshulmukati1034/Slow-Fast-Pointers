public class Q13_FindlengthofLoop {

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }   

    public static int countNodes(Node node) {
        int res = 1;
        Node curr = node;
        while (curr.next != node) {
            res++;
            curr = curr.next;
        }
        return res;
    }
    
    public static int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        while (slow != null && fast != null 
               && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // if slow and fast meet at
            // some point then there is a loop
            if (slow == fast)
                return countNodes(slow);
        }

        return 0;
    }

    public static void main(String[] args) {
        // Example usage:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a loop for testing

        int loopLength = lengthOfLoop(head);
        System.out.println("Length of the loop in the linked list: " + loopLength);
    }   
}
