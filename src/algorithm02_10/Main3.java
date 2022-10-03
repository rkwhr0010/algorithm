package algorithm02_10;

import java.util.*;
class Main3 {	
	public int solution(int n, int[][] arr){
		int answer=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(isBig(arr, i, j)) {
					answer++;
//					System.out.print(arr[i][j]+",");
				}
			}
//			System.out.println();
		}
		return answer;
	}
//	void prettyPrint(int[][] arr) {
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr.length;j++) {
//				System.out.printf("%3s ", arr[i][j]);
//			}
//			System.out.println();
//		}
//	}

	private boolean isBig(int[][]arr, int i, int j) {
		boolean top = i==0?true : bigThanTop(arr, i, j);
		boolean bottom = i==arr.length-1? true : bigThanBottom(arr, i, j);
		boolean left = j==0?true : bigThanLeft(arr, i, j);
		boolean right = j==arr.length-1?true : bigThanRight(arr, i, j);
		
		return (top&&bottom&&left&&right);
		
	}
	private boolean bigThanTop(int[][]arr, int i, int j) {
		return arr[i][j] <= arr[i - 1][j] ? false: true;
	}
	private boolean bigThanBottom(int[][]arr, int i, int j) {
		return arr[i][j] <= arr[i + 1][j] ? false : true;
	}
	private boolean bigThanLeft(int[][]arr, int i, int j) {
		return arr[i][j] <= arr[i][j - 1] ? false : true;
	}
	private boolean bigThanRight(int[][]arr, int i, int j) {
		return arr[i][j] <= arr[i][j + 1] ? false : true;
	}
	
	public static void main(String[] args){
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
	}
}