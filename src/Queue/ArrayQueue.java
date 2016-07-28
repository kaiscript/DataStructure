package Queue;

import java.lang.reflect.Array;

/**
 *@author Kaiscript
 *
 *2016年7月18日下午11:33:48
 * @param <T>
 */
public class ArrayQueue<T> {
	
	private T[] array;
	
	private int count;
	
	public ArrayQueue(Class type,int count){
		array = (T[]) Array.newInstance(type, count);
		count = 0;
	}

	public void add(T value){
		array[count++] = value;
	}
	
	public T front(){
		return array[0];
	}
	
	public T pop(){
		T value = array[0];
		for(int i=1;i<=count;i++){
			array[i-1] = array[i];
		}
		count--;
		return value;
	}
	
	public int size(){
		return count;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public static void main(String[] args){
		
		ArrayQueue<String> queue = new ArrayQueue(String.class,20);
		for(int i=0;i<=10;i++){
			queue.add("00"+i);
		}
		System.out.println("size:"+queue.size());
		while(!queue.isEmpty()){
			System.out.println(queue.pop());
		}
		
	}
	
}
