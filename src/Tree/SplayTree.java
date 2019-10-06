package Tree;

/**
 * 拓展树SplayTree
 *@author Kaiscript
 *
 *2016年7月27日下午8:39:56
 */
public class SplayTree<T extends Comparable<T>> {
	
	public STNode<T> mRoot;
	
	public static class STNode<T>{
		private T value;
		private STNode<T> left;
		private STNode<T> right;
		private STNode<T> parent;
		public STNode(T value, STNode<T> left, STNode<T> right, STNode<T> parent) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
	}
	
	/**
	 * 自底向上
	 * @param <T>
	 * @param v
	 */
	public STNode<T> splay(STNode<T> v){ 
		STNode<T> p = null;
		STNode<T> g = null;
		p = v.parent;
		g = p.parent;
		int i=0;
		while(p!=null && g!=null){
			
			STNode<T> gp = g.parent; 
			
			if(p.left==v){
				if(g.left==p){ //zig-zig
					attachAsLChild(g, p.right);
					attachAsLChild(p, v.right);
					attachAsRChild(v, p); //v.right = p;
					attachAsRChild(p, g);
					
				}
				else if(g.right==p){ //zig-zag
					attachAsLChild(p, v.right);
					attachAsRChild(g, v.left);
					attachAsLChild(v, g);
					attachAsRChild(v, p);
				}
				
			}
			else if(p.right==v){ //zag
				if(g.left == p){ //zag-zig
					attachAsRChild(p, v.left);
					attachAsLChild(g, v.right);
					attachAsRChild(v, g);
					attachAsLChild(v, p);
				}
				else if(g.right == p){ //zag-zag
					attachAsRChild(g, p.left);
					attachAsRChild(p, v.left);
					attachAsLChild(p, g);
					attachAsLChild(v, p);
				}
			}
			
			if(gp!=null){
				if(gp.left == g){//祖父节点是曾祖父节点的左孩子
					attachAsLChild(gp, v);
				}
				else{
					attachAsRChild(gp, v);
				}
			}
			//双层拓展，故向上移动，拿到父节点，祖父节点
			p = v.parent;
			if(p!=null){
				g = p.parent;
			}
			v.parent = null;
		}
		
		//父节点不为空，但祖父节点为空的情况也就是当树的高度只有奇数的时候，再进行一次单旋操作
		if(p!=null){
			if(p.left == v){
				attachAsLChild(p, v.right);
				attachAsRChild(v, p);
			}
			else if(p.right == v){
				attachAsRChild(p, v.left);
				attachAsLChild(v, p);
			}
		}
		
		v.parent = null; //v已经拓展完毕，是根节点，parent为null
		mRoot = v;
		return v;
		
	}
	
	/**
	 * 查找某节点,包括了拓展操作
	 * @param t
	 * @return
	 */
	public STNode<T> search(T t){
		
		STNode<T> x = mRoot;
		STNode<T> y = null;
		
		while(x!=null){
			y = x;
			int cmp = t.compareTo(x.value);
			if(cmp>0)
				x = x.right;
			else if(cmp<0)
				x = x.left;
			else
				break;
		}
		splay(x);
		return y;
	}
	
	public void insertWithoutSplay(T t){
		STNode<T> node = new STNode<T>(t,null,null,null);
		insert(this,node);
	}
	
	public STNode<T> insert(SplayTree<T> tree,STNode<T> node){ 
		int cmp;
		STNode<T> x = mRoot;
		STNode<T> y = null;
		while(x!=null){
			cmp = node.value.compareTo(x.value);
			y = x;
			if(cmp>0)
				x = x.right;
			else
				x = x.left;
			
		}
		node.parent = y;
		if(y==null)
			tree.mRoot = node;
		else{
			cmp = node.value.compareTo(y.value);
			if(cmp>0)
				y.right = node;
			else
				y.left = node;
		}
		return node;
	}
	
	public STNode<T> minium(STNode<T> tree){
		if(tree==null){
			return tree;
		}
		while(tree.left!=null){
			tree = tree.left;
		}
		return tree;
	}
	
	/**
	 * 中序遍历
	 * @param tree
	 */
	public void inOrder(STNode<T> tree){
		if(tree!=null){
			if(tree.left!=null)
				inOrder(tree.left);
			System.out.print(tree.value+" ");
			if(tree.right!=null)
				inOrder(tree.right);
		}
	}
	
	public void inOrder(){
		inOrder(mRoot);
	}
	
	/**
	 * 将b作为a的左子树
	 * @param a
	 * @param b
	 */
	public <T> void attachAsLChild(STNode<T> a,STNode<T> b){
		a.left = b;
		if(b!=null)
			b.parent = a;
	}
	
	/**
	 * 将b作为a的右子树
	 * @param a
	 * @param b
	 */
	public <T> void attachAsRChild(STNode<T> a,STNode<T> b){
		a.right = b;
		if(b!=null)
			b.parent = a;
	}
	
	public static void main(String[] args) {
		int arr[] = {10,50,40,30,20,60};
		SplayTree<Integer> tree = new SplayTree<>();
		for(int i:arr){
			tree.insertWithoutSplay(i);
		}
		System.out.println("mRoot value:"+tree.mRoot.value);
		tree.inOrder();

//		tree.splay(tree.minium(tree.mRoot.right));
		System.out.println();
		tree.search(20);//include splay
		System.out.println("mRoot value:"+tree.mRoot.value);

	}

}
