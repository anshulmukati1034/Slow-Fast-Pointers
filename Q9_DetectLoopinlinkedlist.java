public class Q9_DetectLoopinlinkedlist {

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static boolean detectLoop(Node head) {
        // code here
        Node slow=head;
        Node fast=head;
        
        while(fast !=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage:
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creating a loop for testing

        boolean hasLoop = detectLoop(head);
        System.out.println("Does the linked list have a loop? " + hasLoop);
    }
}
