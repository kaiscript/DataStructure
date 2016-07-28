package Stack;

import java.lang.reflect.Array;

/**
 * 数组实现的栈
 *@author Kaiscript
 *
 *2016年7月18日下午10:19:21
 * @param <T>
 */
public class ArrayStack<T> {

	private T[] array;
	private int count;
	
	public ArrayStack(Class<T> type,int size){
		array = (T[]) Array.newInstance(type, size);
		count = 0;
	}

	public void push(T value){
		array[count++] = value;
	}
	
	public T peek(){
		return array[count-1];
	}
	
	public T pop(){
		T value = array[count-1];
		count--;
		return value;
	}
	
	public int size(){
		return count;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public void printStack(){
		if(count==0)
			System.out.println("Stack is empty!");
		int i = size()-1;
		while(i>=0){
			System.out.println(array[i]);
			i--;
		}
	}
	
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack<>(String.class, 10);
		for(int i=0;i<10;i++){
			stack.push("00"+i);
		}
		stack.printStack();
		System.out.println("---pop---");
		stack.pop();
		stack.printStack();
	}

}
