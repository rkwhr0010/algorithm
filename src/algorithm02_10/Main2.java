package algorithm02_10;

import java.util.*;
class Main2 {	
	public int solution(int n, int[][] arr){
		int answer=0;
		int[][] arrTmp = new int[n+2][n+2];
		for(int i=0;i<arr.length;i++) {
			System.arraycopy(arr[i], 0, arrTmp[i+1], 1, arr[i].length);
		}
//		System.out.println(Arrays.deepToString(arrTmp));
		//가장자리는 항상 0 그래서 1 부터 시작
		//끝자리는 항상 0 ,그래서 크기 +2 , 또한 끝자리 확인 불필요 -1 , 즉, +1
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(isTop(arrTmp, i, j)) {
					answer++;
				}
			}
		}
		return answer;
	}

	private boolean isTop(int[][]arr, int i, int j) {
		
		return arr[i][j] < arr[i - 1][j] ? false
		     : arr[i][j] < arr[i + 1][j] ? false
		     : arr[i][j] < arr[i][j - 1] ? false 
		     : arr[i][j] < arr[i][j + 1] ? false : true;
	}
	
	
	
	public static void main(String[] args){
		Main2 T = new Main2();
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