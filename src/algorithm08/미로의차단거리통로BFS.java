package algorithm08;


import java.util.*;

class 미로의차단거리통로BFS {
	static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	static int[][] board, dis;
	static int cnt = 0;
	static int answer = Integer.MAX_VALUE;
	
	static void BFS(int x, int y){
		Queue<Point> Q=new LinkedList<>();
		Q.offer(new Point(x, y));
		board[x][y]=1;
		while(!Q.isEmpty()){
			Point tmp=Q.poll();
			for(int i=0; i<4; i++){
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
					board[nx][ny]=1;
					Q.offer(new Point(nx, ny));
					dis[nx][ny]=dis[tmp.x][tmp.y]+1;
				}
			}
		}	
	}
	
	
	static void BFS3(int x,int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y));
		board[x][y]=1;
		while(!q.isEmpty()) {
			int size = q.size();
			//Q 순회용 
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				// Q 요소의 다음 갈 곳 순회용
				for (int j = 0; j < dx.length; j++) {
					int nx = p.x+dx[j]; //다음갈 곳
					int ny = p.y+dy[j];
					if(nx>=1&&nx<=7 && ny>=1&&ny<=7 &&board[nx][ny]==0) {
						board[nx][ny] = 1;
						dis[nx][ny] = dis[p.x][p.y]+1;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		dis=new int[8][8];
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
		
		BFS3(1, 1);
		for(int[] y : dis) {
			for (int x : y) {
				System.out.printf("%2s ", x);
			}
			System.out.println();
		}
		if(dis[7][7]==0) System.out.println(-1); //목적지 도달 불가
		else System.out.println(dis[7][7]);
	}
}

class Point{
	public int x, y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x+":"+y;
	}
}