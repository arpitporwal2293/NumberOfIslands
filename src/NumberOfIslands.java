
public class NumberOfIslands {

	//check if the point is between boundaries and has value one and not visited
	public static boolean isSafe(int[][] arr,int row,int col,int[][] visited,int ROW,int COL){
		if(row>=0 && row<ROW && col>=0 && col<COL && arr[row][col]==1 && visited[row][col]==0)
			return true;
		else
			return false;
	}
	
	public static void DFS(int[][] arr,int row,int col,int[][] visited,int ROW,int COL){
		//coordinates of all points neighboring current point
		int[] rowCom = {-1,-1,-1,0,0,1,1,1};
		int[] colCom = {-1,0,1,-1,1,-1,0,1};
		
		//make the point visited
		visited[row][col] = 1;
		
		for(int k=0;k<8;k++){
			if(isSafe(arr,row+rowCom[k],col+colCom[k],visited,ROW,COL)){
				//recurse for neighboring nodes
				DFS(arr,row+rowCom[k],col+colCom[k],visited,ROW,COL);
			}
		}
	}
	
	public static int countIslands(int[][] arr,int ROW,int COL,int[][] visited){
		int count = 0;
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COL;j++){
				//if found 1 then check its neighbors and increment island count
				if(arr[i][j]==1 && visited[i][j]==0){
					DFS(arr, i, j, visited, ROW, COL);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 1, 0, 0, 0},
		        {1, 0, 1, 0, 1}};
		int[][] visited = new int[5][5];
		int count = countIslands(arr, 5, 5, visited);
		System.out.println(count);
	}
	
}
