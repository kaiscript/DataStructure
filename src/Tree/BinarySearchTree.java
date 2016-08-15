package Tree;


/**
 *@author Kaiscript
 *
 *2016��7��24������7:39:22
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BSNode<T> mRoot;
	
	public class BSNode<T>{
		T key;
		private BSNode<T> left;
		private BSNode<T> right;
		private BSNode<T> parent;
		public BSNode(T key, BSNode<T> left,BSNode<T> right,BSNode<T> parent) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
	}
	
	public void preOrder(BSNode<T> tree){
		if(tree!=null){
			System.out.print(tree.key+" ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	
	/**
	 * ǰ�����
	 */
	public void preOrder(){
		preOrder(mRoot);
	}
	
	/**
	 * �������
	 * @param tree
	 */
	public void inOrder(BSNode<T> tree){
		if(tree!=null){
			inOrder(tree.left);
			System.out.print(tree.key+" ");
			inOrder(tree.right);
		}
	}
	
	public void inOrder(){
		inOrder(mRoot);
	}
	
	/**
	 * �������
	 * @param tree
	 */
	public void postOrder(BSNode<T> tree){ 
		if(tree!=null){
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.key+" ");
		}
	}
	
	public void postOrder(){
		postOrder(mRoot);
	}
	
	public BSNode<T> search(T t,BSNode<T> x){
		if(x==null)
			return x;
		int cmp = t.compareTo(x.key);
		if(cmp < 0)
			return search(t,x.left);
		else if(cmp > 0)
			return search(t, x.right);
		else
			return x;
		
	}
	
	/**
	 * �ǵݹ�汾
	 * @param t
	 * @param x
	 * @return
	 */
	public BSNode<T> iterativeSearch(T t,BSNode<T> x){ 
		while(x!=null){
			int cmp = t.compareTo(x.key);
			if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
			else
				return x;
		}
		return x;
	}
	
	public BSNode<T> maxium(BSNode<T> tree){
		if(tree==null)
			return tree;
		while(tree.right!=null){
			tree = tree.right;
		}
		return tree;
	}
	
	public BSNode<T> minium(BSNode<T> tree){
		if(tree==null){
			return tree;
		}
		while(tree.left!=null){
			tree = tree.left;
		}
		return tree;
	}
	
	/**
	 * Ѱ��ǰ���ڵ�
	 * @param x
	 * @return
	 */
	public BSNode<T> predecessor(BSNode<T> x){
		//���x������ڵ㣬��x��ǰ��Ϊ ������Ϊ�������������ڵ�
		if(x.left!=null)
			return maxium(x.left);
		
		//���xû�����ӣ����Һ��ӣ�����2�ֿ��ܣ�
		//(1) x���丸�ڵ������������ǰ��Ϊx�ĸ��ڵ�
		//(2) x���丸�ڵ������������ǰ��Ϊ x����׸��ڵ㣬�ø��ڵ������������
		
		BSNode<T> y = x.parent;
		while(y!=null && y.left==x){
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * Ѱ�Һ����ڵ�
	 * @param x
	 * @return
	 */
	public BSNode<T> successor(BSNode<T> x){
		if(x.right!=null)
			return minium(x.right);
		
		BSNode<T> y = x.parent;
		while(y!=null && y.right==x){
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * ����
	 * @param tree
	 * @param node
	 */
	public void insert(BinarySearchTree<T> tree,BSNode<T> node){
		int cmp;
		BSNode<T> y = null;
		BSNode<T> x = tree.mRoot;
		while(x!=null){
			cmp = node.key.compareTo(x.key);
			y = x;
			if(cmp<0)
				x = x.left;
			else if(cmp>0)
				x = x.right;
		}
		node.parent = y;
		if(y==null)
			tree.mRoot = node;
		else{
			cmp = node.key.compareTo(y.key);
			if(cmp<0)
				y.left = node;
			else
				y.right = node;
		}
		
	}
	
	public void insert(T t){
		BSNode<T> z=new BSNode<T>(t,null,null,null);
		if(z!=null)
			insert(this,z);
		
	}
	
	/**
	 * ɾ���ڵ�
	 * @param t
	 * @param node
	 * @return
	 */
	public BSNode<T> remove(T t,BSNode<T> node){
		if(node==null)
			return null;
		int cmp = t.compareTo(node.key);
		if(cmp<0){
			node.left = remove(t,node.left);
		}
		else if(cmp>0){
			node.right = remove(t,node.right);
		}
		else if(node.left!=null && node.right!=null){
			node.key = minium(node.right).key;
			node.right = remove(t,node.right);
		}
		else
			node = node.left==null?node.right:node.left;
		return node;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,4,3,2,6};
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		for(Integer a:arr){
			tree.insert(a);
		}
		System.out.println("\nǰ�������");
		tree.preOrder();
		System.out.println("\n�������:");
		tree.inOrder();
		System.out.println("\n�������:");
		tree.postOrder();
	}

}
