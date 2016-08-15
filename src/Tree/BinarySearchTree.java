package Tree;


/**
 *@author Kaiscript
 *
 *2016年7月24日下午7:39:22
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
	 * 前序遍历
	 */
	public void preOrder(){
		preOrder(mRoot);
	}
	
	/**
	 * 中序遍历
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
	 * 后序遍历
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
	 * 非递归版本
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
	 * 寻找前驱节点
	 * @param x
	 * @return
	 */
	public BSNode<T> predecessor(BSNode<T> x){
		//如果x存在左节点，则x的前驱为 其左孩子为根的子树的最大节点
		if(x.left!=null)
			return maxium(x.left);
		
		//如果x没有左孩子，有右孩子，则有2种可能：
		//(1) x是其父节点的右子树，则前驱为x的父节点
		//(2) x是其父节点的左子树，则前驱为 x的最底父节点，该父节点必须有右子树
		
		BSNode<T> y = x.parent;
		while(y!=null && y.left==x){
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * 寻找后驱节点
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
	 * 插入
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
	 * 删除节点
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
		System.out.println("\n前序遍历：");
		tree.preOrder();
		System.out.println("\n中序遍历:");
		tree.inOrder();
		System.out.println("\n后序遍历:");
		tree.postOrder();
	}

}
