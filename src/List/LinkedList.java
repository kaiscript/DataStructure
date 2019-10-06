package List;

/**
 * Created by kaiscript on 2019/10/6.
 */
public class LinkedList {

    Node head;

    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        }
        else{
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    /**
     * Find nth element from end of linked list
     * @param head
     * @param n
     * @return
     */
    public Node findNthFromEndOfLinkedList(Node head, int n) {
        Node firstPoint = head;
        Node secondPoint = head;
        for (int i = 0; i < n; i++) {
            firstPoint = firstPoint.next;
        }
        while (firstPoint.next != null) {
            firstPoint = firstPoint.next;
            secondPoint = secondPoint.next;
        }
        return secondPoint;
    }

    /**
     *  find middle element in linkedlist
     * @param head
     * @return
     */
    public Node findMiddleNode(Node head) {
        Node fastPoint = head;
        Node slowPoint = head;
        while (fastPoint.next != null && slowPoint.next != null) {
            fastPoint = fastPoint.next;
            if (fastPoint != null) {
                fastPoint = fastPoint.next;
                slowPoint = slowPoint.next;
            }
        }
        return slowPoint;
    }

    /**
     * 1.find middle node
     * 2.reverse linkelist for second part
     * @param head
     * @return
     */
    public boolean checkPalindrome(Node head) {
        Node middleNode = findMiddleNode(head);
        Node secondNode = middleNode.next;
        //第二条链表（反转后的）的头结点
        Node node = reverseLinkedListIterative(secondNode);
        while (head != null && node != null) {
            if (head.value == node.value) {
                head = head.next;
                node = node.next;
                continue;
            }
            else
                return false;
        }
        return true;
    }

    public Node reverseLinkedListIterative(Node currentNode) {
        Node previousNode = null;
        Node nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            //移动到下一个node，再进行迭代
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Creating a linked list
        Node head = new Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));
        list.printList();
        System.out.println("-----------链表末尾算起的第" + 1 + "个节点");
        System.out.println(list.findNthFromEndOfLinkedList(head, 1).value);
        System.out.println("-----------判断是否回文链表");
        LinkedList palindromeList = new LinkedList();
        Node palindromeHead=new Node(1);
        palindromeList.addToTheLast(palindromeHead);
        palindromeList.addToTheLast(new Node(2));
        palindromeList.addToTheLast(new Node(1));
        palindromeList.addToTheLast(new Node(2));
        palindromeList.addToTheLast(new Node(1));
        palindromeList.printList();
        System.out.println(palindromeList.checkPalindrome(palindromeHead));

    }

}
