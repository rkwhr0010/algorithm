package algorithm08;

import java.util.LinkedList;
import java.util.Queue;

class 섬나라아일랜드BFS {
	static int answer=0, n;
	static int[] dx={-1, -1, 0, 1, 1, 1 , 0 , -1};
	static int[] dy={0 , 1 , 1, 1, 0, -1, -1, -1};
	static Queue<Point> q = new LinkedList<섬나라아일랜드BFS.Point>();
	
	
	static void BFS(int[][] board,int x, int y) {
		
		q.offer(new Point(x, y));
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				for (int j = 0; j < dx.length; j++) {
					int nx = p.x+dx[j];
					int ny = p.y+dy[j];
					if(nx>=0&&nx<n && ny>=0&&ny<n && board[nx][ny]==1) {
						board[nx][ny] = 99;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && nx<n &&ny >=0 &&ny <n &&board[nx][ny]==1 ) {
				board[nx][ny] = 99;
			}
			
		}
	}
	public void solution(int[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==1) {
					answer++;
					board[i][j] = 99;
					BFS(board, i, j);
					
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
	static  class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args){
		섬나라아일랜드BFS T = new 섬나라아일랜드BFS();
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