package List;

/**
 *
 * 单链表实现
 * Created by kaiscript on 2019/10/5.
 */
public class SinglyLinkedList {


    private Node head;

    /**
     * 在链表头部插入
     * @param data
     */
    public void insertFirst(int data) {
        Node first = new Node(data);
        first.next = head;
        head = first;
    }

    /**
     * 删除首节点
     */
    public void deleteFirst() {
        Node first = head;
        head = head.next;
        first = null;
    }

    public void insertLast(int data) {
        Node last = new Node(data);
        Node node = head;
        Node q = null;
        while (node != null) {//&& (node = node.next) != null
            q = node;
            node = node.next;
        }
        q.next = last;
    }

    public void deleteByValue(int value) {
        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;//记录前一个节点
            p = p.next;
        }
        //value是头结点
        if (q == null) {
            head.next = head.next.next;
        }
        else{
//            q.next = p.next;
            q.next = q.next.next;
        }

    }

    public void printLinkedList() {
        System.out.println("Printing LinkedList (head --> last) ");
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
        public void displayNodeData() {
            System.out.println("{ " + data + " } ");
        }
    }


    /**
     * 迭代法-反转单链表
     * @param currentNode
     * @return
     */
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
        head = previousNode;
        return previousNode;
    }

    public Node reverseLinkedListRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node remaining = reverseLinkedListRecursive(node.next);
        node.next.next = node;
        node.next = null;
        head = remaining;
        return remaining;
    }

    public static void main(String[] args) {
        SinglyLinkedList myLinkedlist = new SinglyLinkedList();
        myLinkedlist.insertFirst(5);
        myLinkedlist.insertFirst(6);
        myLinkedlist.insertFirst(7);
        myLinkedlist.insertFirst(1);
        myLinkedlist.insertLast(2);
        myLinkedlist.printLinkedList();
        System.out.println("--------------deleteByValue:7------------");
        myLinkedlist.deleteByValue(7);
        myLinkedlist.printLinkedList();
        System.out.println("--------------deleteFirst------------");
        myLinkedlist.deleteFirst();
        myLinkedlist.printLinkedList();
        System.out.println("--------------reverseLinkedListIterative------------");
        Node node = myLinkedlist.reverseLinkedListIterative(myLinkedlist.head);
        myLinkedlist.printList(node);
        System.out.println("--------------reverseLinkedListRecursive------------");
        Node node1 = myLinkedlist.reverseLinkedListRecursive(myLinkedlist.head);
        myLinkedlist.printList(node1);
    }

}
