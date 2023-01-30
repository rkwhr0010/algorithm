package algorithm08;

class 미로탐색DFS {
	//다음 방향을 결정
	static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	
	static int[][] board; 
	static int[][] path;  // 경로 확인용
	static int answer=0;
	static int cnt=1;

	static void DFS2(int x, int y){
		if(x==7 && y==7) {
			answer++;
			System.out.println(answer+"번 째 경로");
			for (int i = 0; i < path.length; i++) {
				for (int j = 0; j < path[i].length; j++) {
					if(i==0||j==0) {
						System.out.printf("%2s",i==0?"--":"|");
						continue;
					}
					System.out.printf("%2s",path[i][j]==0?"":path[i][j]+"");
				}
				System.out.println();
			}
			System.out.println();
			
			return;
		} else {
			for (int i = 0; i < dx.length; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(1<=nx&&nx<=7&&1<=ny&&ny<=7 && board[nx][ny]==0) {
					cnt++;
					board[nx][ny] =1;
					path[nx][ny] =cnt;
					
					DFS2(nx,ny);
					
					board[nx][ny] =0;
					path[nx][ny] =0;
					cnt--;
				}
			}
		}
	}
	
	
	static void DFS(int x, int y){
		if(x==7 && y==7) answer++;
		else{
			for(int i=0; i<4; i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
					board[nx][ny]=1;
					DFS(nx, ny);
					
					board[nx][ny]=0;
				}
			}
		}	
	}

	
	
	public static void main(String[] args){
		path=new int[8][8];
		//인덱스 [0][n], [n][0]은 버리는 공간, 1부터 시작을 위함
		int[][] arr = 
			{ {0, 0, 0, 0, 0, 0, 0, 0}
			/*-----------------------*/
			, {0,/**/ 0, 0, 0, 0, 0, 0, 0}
			, {0,/**/ 0, 1, 1, 1, 1, 1, 0}
			, {0,/**/ 0, 0, 0, 1, 0, 0, 0}
			, {0,/**/ 1, 1, 0, 1, 0, 1, 1}
			, {0,/**/ 1, 1, 0, 0, 0, 0, 1}
			, {0,/**/ 1, 1, 0, 1, 1, 0, 0}
			, {0,/**/ 1, 0, 0, 0, 0, 0, 0} };
		
		board = arr.clone();
		
		board[1][1]=1;
		path[1][1]=1;
		DFS2(1, 1);
		System.out.println(answer+" 개 경로 존재");
	}
}