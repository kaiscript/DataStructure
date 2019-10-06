package List;

/**
 * reversing linked list in pairs
 * Created by kaiscript on 2019/10/6.
 */
public class ReverseLinkedListInPair {

    private Node head;

    /**
     * µü´ú·¨
     * @param head
     * @return
     */
    public Node reverseLinkedListInPairIterator(Node head) {
        Node newHead = null;

        Node current = head;
        Node temp = null;
        while (current != null && current.next != null) {
            if (temp != null) {
                temp.next.next = current.next;
            }
            temp = current.next;
            current.next = temp.next;
            temp.next = current;

            if (newHead == null) {
                newHead = temp;
            }
            current = current.next;

        }
        return newHead;
    }

    /**
     * µÝ¹é·¨
     * @param head
     * @return
     */
    public Node reverseLinkedListInPairRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head.next = reverseLinkedListInPairRecursive(head.next);
        return temp;
    }

    public static void main(String[] args) {
        ReverseLinkedListInPair list = new ReverseLinkedListInPair();
        // Creating a linked list
        Node head=new Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));
        list.addToTheLast(new Node(8));

        list.printList(head);
        //Reversing LinkedList in pairs
        Node result = list.reverseLinkedListInPairRecursive(head);
        System.out.println("After reversing in pair");
        list.printList(result);
    }

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;

        }
    }

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }


    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }



}
