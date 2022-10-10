package algorithm02;

import java.util.*;
class Main02_09 {	
	public int solution(int n, int[][] arr){
		int max = Integer.MIN_VALUE;
		
		int rowSum, colSum, cSum1=0,cSum2=0;
		
		for(int i= 0; i<n; i++) {
			rowSum=0;
			colSum=0;
			//핵심 같은 반복문이라도 구조가 유사하니
			//j , i 위치만 바꾸면 한방에 해결
			//구조 i==j , i+j == length-1 , [고정][순회], [순회],[고정]
			for(int j= 0; j<n ;j++) {
				rowSum += arr[i][j]; //같은 행 합
				colSum += arr[j][i]; //같은 열 합
			}
			cSum1+=arr[i][i];
			cSum2+=arr[i][n-1-i];
			// 내가 틀린 부분; 기존 값이 신규 값보다 더 클 수 있다는 것을 간과
//			max = rowSum<colSum ? colSum : rowSum;
			max = max < rowSum ? rowSum 
			    : max < colSum ? colSum : max ;
		}
		
		max = max < cSum1 ? cSum1 
			: max < cSum2 ? cSum2 : max;
		
		return max;
	}
	

	public static void main(String[] args){
		Main02_09 T = new Main02_09();
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