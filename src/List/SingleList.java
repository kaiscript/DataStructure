package List;

/**
 * 单链表(head不存值，只作引用)
 *@author Kaiscript
 *
 *2016年7月17日上午11:39:53
 */
public class SingleList<T> {
	
	public Node<T> head;
	
	private static int count;
	
	private class Node<T>{
		
		public Node next;
		public T value;
		
		public Node(Node next, T value) {
			super();
			this.next = next;
			this.value = value;
		}
		
	}
	
	public SingleList(){
		head = new Node<T>(null, null);
		count = 0;
	}
	
	public Node<T> getNode(int index){
		
		Node<T> node = head;
		
		for(int i=0;i<=index;i++){
			node = node.next;
		}
		return node;
		
	}
	
	public void insert(int index,T value){
		
		Node node = null;
		if(index==0){
			node = new Node(head.next,value);
			head.next = node;
			count++;
			return;
		}
		Node indexNode = getNode(index);
		node = new Node(indexNode,value);
		getNode(index-1).next = node;
		node.next = null;
		count++;
		return;
	}
	
	public void append(T value){
		if(count==0){
			Node<T> node = new Node(null,value);
			head.next = node;
			count++;
			return;
		}
		
		Node<T> lastNode = getNode(count-1);
		Node<T> node = new Node(null,value);
		lastNode.next = node;
		count++;
	}
	
	public void delete(int index){
		getNode(index-1).next = getNode(index+1);
		count--;
	}
	
	public T getValue(int index){
		return getNode(index).value;
	}
	
	public int size(){
		return count;
	}
	
	/**
	 * 翻转单链表(遍历)
	 * @return
	 */
	public Node<T> reverseSingleList(){
		Node pre = head;
		Node current = head.next;
		Node next = null;
		
		while(current!=null){
			next = current.next;
			current.next = pre;
			
			pre = current;
			current = next;
		}
		head.next = pre;
		return head;
	}
	
	public Node<T> reverseSingleListByRecur(Node<T> cur){
		if(cur==null || cur.next==null){
			head.next = cur;
			return cur;
		}
		Node<T> next = cur.next;
		cur.next = null;
		Node<T> node = reverseSingleListByRecur(next);
		next.next = cur;
		
		return node;
	}
	
	public void reverseSingleListByRecur(){
		reverseSingleListByRecur(head);
	}
	
	public static void main(String[] args){
		SingleList<String> list = new SingleList<>();
		for(int i=0;i<3;i++){
			list.append("00"+i);
		}
		System.out.println("---list---");
		for(int i=0;i<list.size();i++){
			System.out.print(list.getValue(i)+" ");
		}

		
		System.out.println("\n---delete---");
		list.delete(1);
		for(int i=0;i<list.size();i++){
			System.out.print(list.getValue(i)+" ");
		}
		
		
		System.out.println("\n---reverseSingleList---");
		list.reverseSingleList();
		for(int i=0;i<list.size();i++){
			System.out.print(list.getValue(i)+" ");
		}
		
		System.out.println("\n---reverseSingleListByRecur---");
		list.reverseSingleListByRecur();
		
		for(int i=0;i<list.size();i++){
			System.out.print(list.getValue(i)+" ");
		}
		
		
	}
	
}
