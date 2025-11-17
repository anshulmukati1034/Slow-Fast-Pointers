public class Q2_MiddleoftheLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static Node findMiddle(Node head){
       

        Node slow = head;
        Node fast = head;
        Node temp = head;
        int count = 0;

        while (temp != null){
            count++;
            temp = temp.next;
        }

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (count % 2 == 0){
            return slow.next; // second middle for even length
        } else {
            return slow; // middle for odd length
        }
    }

   
    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);


        Node middle = findMiddle(head);
        if (middle != null){
            System.out.println("Middle Node: " + middle.data);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
