package Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * ����
 *@author Kaiscript
 *
 *2016��7��26������1:36:25
 */
public class MaxHeap<T extends Comparable<T>> {
	
	private List<T> mHeap;
	
	public MaxHeap(){
		mHeap = new ArrayList<T>();
	}
	
	/**
	 * �Ե����ϵ���
	 * @param start
	 */
	public void filterUp(int start){
		int c = start;
		int p = (start-1)/2;
		T tmp = mHeap.get(c);
		
		//�ȱ�������ֵ����¼����ֵ��index��index��Ӧ��ֵ�ȸ��ڵ�󣬾�һֱ��ֵ����Ϊ���ڵ��ֵ���൱�ڽ����ڵ��ֵ�����ƣ�Ȼ���ٵ���index��ֵ����
		//��󽫲���ֵ���õ���ȷ��λ��
		while(c>0){
			int cmp = mHeap.get(p).compareTo(tmp);
			if(cmp>=0)
				break;
			else{
				mHeap.set(c, mHeap.get(p));//���׽ڵ�Ⱥ��ӽڵ�С����Ѻ��ӵ�ֵ����Ϊ���׵�ֵ
				c = p;
				p = (p-1)/2;
			}
			mHeap.set(c, tmp);
		}
	}
	
	/**
	 * �Զ����µ���
	 * @param start
	 */
	public void filterDown(int start,int end){
		int c = start;
		int l = c*2+1;
		T tmp = mHeap.get(c);
		
		while(l<=end){
			int cmp = mHeap.get(l).compareTo(mHeap.get(l+1));
			l = cmp>0?l:l+1; //�Ƚ����������ĸ�����
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
