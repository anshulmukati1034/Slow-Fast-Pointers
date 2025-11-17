import java.util.LinkedList;

public class Q1_LinkedListCycle {
    
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;

    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow == fast){
                return true;
            }
            
        }
        return false;
    }

    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Create a cycle manually: 4 → 2
        head.next.next.next = head.next;

         if (hasCycle(head)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
