package Tree;

/**
 * ��չ��SplayTree
 *@author Kaiscript
 *
 *2016��7��27������8:39:56
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
	 * �Ե�����
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
				if(gp.left == g){//�游�ڵ������游�ڵ������
					attachAsLChild(gp, v);
				}
				else{
					attachAsRChild(gp, v);
				}
			}
			//˫����չ���������ƶ����õ����ڵ㣬�游�ڵ�
			p = v.parent;
			if(p!=null){
				g = p.parent;
			}
			v.parent = null;
		}
		
		//���ڵ㲻Ϊ�գ����游�ڵ�Ϊ�յ����Ҳ���ǵ����ĸ߶�ֻ��������ʱ���ٽ���һ�ε�������
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
		
		v.parent = null; //v�Ѿ���չ��ϣ��Ǹ��ڵ㣬parentΪnull
		mRoot = v;
		return v;
		
	}
	
	/**
	 * ����ĳ�ڵ�,��������չ����
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
	 * �������
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
	 * ��b��Ϊa��������
	 * @param a
	 * @param b
	 */
	public <T> void attachAsLChild(STNode<T> a,STNode<T> b){
		a.left = b;
		if(b!=null)
			b.parent = a;
	}
	
	/**
	 * ��b��Ϊa��������
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
