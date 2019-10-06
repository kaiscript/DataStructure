package List;
/**
 * 双链表
 *@author Kaiscript
 *
 *2016年7月17日下午2:52:20
 */
public class DoubleLinkedList<T> {
	
	private int count;
	private Node<T> head;
	
	private class Node<T>{
		public Node prev;
		public Node next;
		public T value;
		public Node(Node prev, Node next, T value) {
			super();
			this.prev = prev;
			this.next = next;
			this.value = value;
		}
		
	}
	
	
	public DoubleLinkedList() {
		head = new Node<T>(null,null,null);
		head.prev = head.next = head;
		count = 0;
	}

	
	public Node<T> getNode(int index){
		Node node = null;
		if(index<count/2){
			node = head.next;
			for(int i=0;i<index;i++){
				node = node.next;
			}
			return node;
		}
		
		node = head.prev;
		int rindex = count - index - 1;
		for(int i=0;i<rindex;i++){
			node = node.prev;
		}
		return node;
	}
	
	public T getValue(int index){
		return getNode(index).value;
	}
	
	public void insert(int index,T value){
		Node indexNode = getNode(index);
		Node newNode = new Node(indexNode.prev,indexNode,value);
		indexNode.prev.next = indexNode.prev = newNode;
		count++;
	}
	
	public void delete(int index){
		
		Node node = getNode(index);
		
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node = null;
		count--;
	}
	
	public void appendLast(T value){
		Node node = new Node<T>(head.prev, head, value);
		head.prev.next = head.prev = node;
		count++;
	}
	
	public Node getFirst(){
		return head.next;
	}
	
	public int size(){
		return count;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<String> list = new DoubleLinkedList<>();
		for(int i=0;i<10;i++){
			list.appendLast("00"+i);
		}
		for(int i=0;i<10;i++){
			System.out.println(list.getValue(i));
		}
		System.out.println("---delete---");
		list.delete(3);
		for(int i=0;i<10;i++){
			System.out.println(list.getValue(i));
		}
		System.out.println("---insert---");
		list.insert(0, "123");
		list.insert(3, "546");
		for(int i=0;i<10;i++){
			System.out.println(list.getValue(i));
		}
	}

}
