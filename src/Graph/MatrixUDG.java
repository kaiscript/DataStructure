package Graph;
/**
 * 邻接矩阵无向图(include dfs,bfs)
 *@author Kaiscript
 *
 *2016年8月7日上午10:40:49
 */
public class MatrixUDG {
	
	private char[] mVexs;
	private int[][] mMatrix;
	
	public MatrixUDG(char[] vexs,char[][] edges){
		int vlen = vexs.length;
		int elen = edges.length;
		mVexs = new char[vlen];
		for(int i = 0;i<vlen;i++){
			mVexs[i] = vexs[i];
		}
		mMatrix = new int[vlen][vlen];
		
		for(int i=0;i<elen;i++){
			int p1 = getPosition(edges[i][0]);
			int p2 = getPosition(edges[i][1]);
			mMatrix[p1][p2] = 1;
			mMatrix[p2][p1] = 1;
		}
					
	}
	
	public int getPosition(char ch){
		for(int i=0;i<mVexs.length;i++){
			if(mVexs[i]==ch)
				return i;
		}
		return -1;
	}
	
	/**
	 * 返回v的第一个邻接节点
	 * @param v
	 * @return
	 */
	public int firstVertex(int v){
		if(v<0 || v>mVexs.length-1)
			return -1;
		for(int i = 0;i<mVexs.length;i++){
			if(mMatrix[v][i]==1)
				return i;
		}
		return -1;
	}
	
	/**
	 * 返回v相对于w的下一个邻接节点的索引
	 * @param v
	 * @param w
	 * @return
	 */
	public int nextVertex(int v,int w){
		if(v<0 || v>mVexs.length-1 || w<0 || w>mVexs.length-1)
			return -1;
		
		for(int i=w+1;i<mVexs.length;i++){
			if(mMatrix[v][i]==1)
				return i;
		}
		return -1;
	}
	
	public void DFS(int v,boolean[] visited){
		visited[v] = true;
		System.out.print(mVexs[v]+" ");
		for(int w = firstVertex(v);w>=0;w=nextVertex(v, w)){
			if(!visited[w])
				DFS(w,visited);
		}
				
	}
	
	/**
	 * 深度优先遍历
	 */
	public void DFS(){
		boolean[] visited = new boolean[mVexs.length];
		for(int i=0;i<visited.length;i++)
			visited[i] = false;
		
		for(int i=0;i<mVexs.length;i++){
			if(!visited[i])
				DFS(i, visited);
		}
		
	}
	
	/**
	 * 广度优先遍历
	 */
	public void BFS(){
		int head = 0;
		int tail = 0;
		int[] queue = new int[mVexs.length];
		boolean[] visited = new boolean[mVexs.length];
		for(int i=0;i<mVexs.length;i++)
			visited[i] = false;
		
		for(int i=0;i<mVexs.length;i++){
			if(!visited[i]){
				visited[i] = true;
				System.out.print(mVexs[i]+" ");
				queue[tail++] = i;//入队
			}
			while(head!=tail){
				int j = queue[head++];//出队
				for(int w = firstVertex(j);w>=0;w = nextVertex(j, w)){
					if(!visited[w]){
						visited[w] = true;
						System.out.print(mVexs[w]+" ");
						queue[tail++] = w; //入队																		
					}
					
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
            {'A', 'C'}, 
            {'A', 'D'}, 
            {'A', 'F'}, 
            {'B', 'C'}, 
            {'C', 'D'}, 
            {'E', 'G'}, 
            {'F', 'G'}};
        MatrixUDG matrix = new MatrixUDG(vexs, edges);
        System.out.println("DFS:");
        matrix.DFS();
        System.out.println("\nBFS:");
        matrix.BFS();
    }

}
