public class Q2_LinkedListCycleII {
    
    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static Node hasCycle(Node head){

        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;  // cycle found
            }
        }

        // ❗ Check if no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find cycle start
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // start of cycle
    }

    public static void main(String[] args) {

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Create a cycle manually: 4 → 2
        head.next.next.next = head.next;

        Node cycleStart = hasCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.data);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
