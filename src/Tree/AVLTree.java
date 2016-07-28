package Tree;
/**
 *@author Kaiscript
 *
 *2016年7月25日下午7:51:47
 */
public class AVLTree<T extends Comparable<T>> {
	
	private AVLNode<T> mRoot;
	
	public class AVLNode<T extends Comparable<T>>{
		private T key;
		int height;
		AVLNode<T> left;
		AVLNode<T> right;
		public AVLNode(T key, int height, AVLNode<T> left,AVLNode<T> right) {
			super();
			this.key = key;
			this.height = height;
			this.left = left;
			this.right = right;
		}
		
	}
	
	/**
	 * LL旋转
	 * @param k2
	 * @return
	 */
	public AVLNode<T> leftLeftRotation(AVLNode<T> k2){ 
		AVLNode<T> k1 = null;
		k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k1.height = max(height(k1.left), height(k1.right))+1;
		k2.height = max(height(k1.left), k2.height)+1;
		
		return k1;
	}
	
	/**
	 * RR旋转
	 * @param k1
	 * @return
	 */
	public AVLNode<T> rightRightRotation(AVLNode<T> k1){ 
		AVLNode<T> k2 = null;
		k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		
		k1.height = max(height(k1.left),height(k1.right))+1;
		k2.height = max(height(k2.right), k1.height)+1;
		
		return k2;
	}
	
	public int height(AVLNode<T> tree){ 
		if(tree!=null)
			return tree.height;
		return 0;
	}
	
	public int height(){
		return height(mRoot);
	}
	
	private int max(int a,int b){
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		
	}

}
