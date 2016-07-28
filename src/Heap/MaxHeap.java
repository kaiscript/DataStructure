package Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大堆
 *@author Kaiscript
 *
 *2016年7月26日下午1:36:25
 */
public class MaxHeap<T extends Comparable<T>> {
	
	private List<T> mHeap;
	
	public MaxHeap(){
		mHeap = new ArrayList<T>();
	}
	
	/**
	 * 自底向上调整
	 * @param start
	 */
	public void filterUp(int start){
		int c = start;
		int p = (start-1)/2;
		T tmp = mHeap.get(c);
		
		//先保留插入值。记录插入值的index，index对应的值比父节点大，就一直将值设置为父节点的值，相当于将父节点的值向下移，然后再调整index的值往上
		//最后将插入值设置到正确的位置
		while(c>0){
			int cmp = mHeap.get(p).compareTo(tmp);
			if(cmp>=0)
				break;
			else{
				mHeap.set(c, mHeap.get(p));//父亲节点比孩子节点小，则把孩子的值设置为父亲的值
				c = p;
				p = (p-1)/2;
			}
			mHeap.set(c, tmp);
		}
	}
	
	/**
	 * 自顶向下调整
	 * @param start
	 */
	public void filterDown(int start,int end){
		int c = start;
		int l = c*2+1;
		T tmp = mHeap.get(c);
		
		while(l<=end){
			int cmp = mHeap.get(l).compareTo(mHeap.get(l+1));
			l = cmp>0?l:l+1; //比较左右子树哪个更大
			cmp = tmp.compareTo(mHeap.get(l));
			if(cmp>=0)
				break;
			else{
				mHeap.set(c, mHeap.get(l));
				c = l;
				l = c*2+1;
			}
		}
		mHeap.set(c, tmp);
	}
	
	public void remove(T t){
		int index = mHeap.indexOf(t);
		int size = mHeap.size();
		mHeap.set(index, mHeap.get(size-1));
		mHeap.remove(size-1);
		filterDown(index, size-1);
		
	}
	
	public void insert(T t){
		mHeap.add(t);
		filterUp(mHeap.size()-1);
	}
	
	public T get(int index){
		return mHeap.get(index);
	}
	
	public int size(){
		return mHeap.size();
	}
	
	public static void main(String[] args) {
		MaxHeap<Integer> heap = new MaxHeap<>();
		System.out.println("---insert---");
		int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
		for(int i:a){
			heap.insert(i);
		}
		for(int i=0;i<heap.size();i++){
			System.out.print(heap.get(i)+" ");
		}
		System.out.println("\n---delete---");
		heap.remove(30);
		for(int i=0;i<heap.size();i++){
			System.out.print(heap.get(i)+" ");
		}
	}
	
}
