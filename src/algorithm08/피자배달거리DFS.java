package algorithm08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 피자배달거리DFS {
	
	static int[] combi; //경우의 수를 채울 배열
	
	static List<Point> hs = new ArrayList<피자배달거리DFS.Point>();
	static List<Point> pz = new ArrayList<피자배달거리DFS.Point>();
	
	static int answer = Integer.MAX_VALUE;
	static int len,n,m;
	
	public static void main(String[] args) {
		피자배달거리DFS T = new 피자배달거리DFS();
		n = 4; //2차원 배열 크기
		m = 4; // 피자 집 선택 수
		int[][] board =  
			{{0, 1, 2, 0}
			,{1, 0, 2, 1}
			,{0, 2, 1, 2}
			,{2, 0, 1, 2}};
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==2) { // 피자집은 2
					pz.add(new Point(i, j));
				}else if(board[i][j]==1) {// 가정집 1
					hs.add(new Point(i, j));
				}//이외는 빈 곳
			}
		}
		len = pz.size();
		combi = new int[m];//경우의 수 배열 
		
		T.DFS(0,0);
		System.out.println(answer);
		
	}
	
	//재귀는 피자집 기준으로 쌓고 있다.
	void DFS(int L, int s) {
		if(L==m) { // 경우의 수 다 채움
			System.out.println(Arrays.toString(combi));
			int sum = 0;
			for(Point h : hs) {
				int dis = Integer.MAX_VALUE;
				//다 찬 경우의 수 배열에는 피자집 위치 정보가 있다.
				for(int i : combi) {
					dis = Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y)) ;
				}
				sum += dis;
			}
			answer = Math.min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
