package algorithm08;

class 섬나라아일랜드DFS {
	static int answer=0, n;
	static int[] dx={-1, -1, 0, 1, 1, 1 , 0 , -1};
	static int[] dy={0 , 1 , 1, 1, 0, -1, -1, -1};
	
	static void DFS(int[][] board,int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n &&ny >=0 &&ny <n &&board[nx][ny]==1 ) {
				board[nx][ny] = 99;
				DFS(board,nx,ny);
			}
			
		}
	}
	public void solution(int[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==1) {
					answer++;
					board[i][j] = 99;
					DFS(board, i, j);
					
					System.out.println("==="+answer+"번 섬지우기===");
					for(int[] a : board) {
						for(int b : a) {
							System.out.printf("%2s ",b);
						}
						System.out.println();
					}
					System.out.println();
				}
			}
		}
	}
	

	public static void main(String[] args){
		섬나라아일랜드DFS T = new 섬나라아일랜드DFS();
		int[][] arr=
				{{1, 1, 0, 0, 0, 1, 0}
				,{0, 1, 1, 0, 1, 1, 0}
				,{0, 1, 0, 0, 0, 0, 0}
				,{0, 0, 0, 1, 0, 1, 1}
				,{1, 1, 0, 1, 1, 0, 0}
				,{1, 0, 0, 0, 1, 0, 0}
				,{1, 0, 1, 0, 1, 0, 0}};
		
		
		n= arr.length;
		T.solution(arr);
		System.out.println(answer);
	}
}