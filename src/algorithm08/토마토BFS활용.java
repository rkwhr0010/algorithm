package algorithm08;

import java.util.*;

class 토마토BFS활용 {
	static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	static int[][] board, dis;
	static int n, m;
	static Queue<Point> Q=new LinkedList<>();
	
	static void BFS2(){
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				Point p = Q.poll();
				
				for (int j = 0; j < dx.length; j++) {
					int nx = p.x+dx[j];
					int ny = p.y+dy[j];
					
					if(nx>=0&&nx<n  && ny>=0&&ny<m && board[nx][ny]==0) {
						board[nx][ny]= 1;
						Q.offer(new Point(nx, ny));
						dis[nx][ny] =dis[p.x][p.y]+1;
					}
				}
			}
		}
	}
	
	
	static void BFS(){
		while(!Q.isEmpty()){
			Point tmp=Q.poll();
			for(int i=0; i<4; i++){
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
					board[nx][ny]=1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny]=dis[tmp.x][tmp.y]+1;
				}
			}
		}	
	}

	public static void main(String[] args){
		m=6; //가로 크기
		n=4; //세로 크기
		board=new int[n][m];
		dis=new int[n][m];
		
		int[][] tmp = 
			{{0, 0, -1, 0, 0, 0}
			,{0, 0, 1, 0, -1, 0}
			,{0, 0, -1, 0, 0, 0}
			,{0, 0, 0, 0, -1, 1}};
		
		board = tmp.clone();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j]==1) Q.offer(new Point(i, j));
				//출발점이 여러개라 미리 넣어둠
			}
		}
		
		BFS2();
		
		//0이 하나라도 존재하면 토마토가 모두 익지 못하는 상황
		long count = Arrays.stream(board)
		      .flatMapToInt(Arrays::stream)
		      .filter(value->value==0)
		      .count();
		if(count>0) System.out.println(-1);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		// 만약 처음부터 모두 익어있다면 자연스럽게 0 출력될 것
		int value = Integer.MIN_VALUE;
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis[i].length; j++) {
				value = Math.max(value, dis[i][j]);
			}
		}
		System.out.println(value);
		for (int[] arr : dis) {
			for (int val : arr) {
				System.out.printf("%2s ",val);
			}
			System.out.println();
		}
		
	}
	static class Point{
		public int x, y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}


