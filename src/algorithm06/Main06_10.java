package algorithm06;

import java.util.*;
//마구간 정하기(결정알고리즘)
/*
5 3
1 2 8 4 9
*/
class Main06_10 {
	public int solution(int n, int c, int[] arr){
		int answer=0;
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[arr.length-1];
		
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			if(count(arr, mid)>=c ) {
				answer = mid;
				lt = mid+1;
			}else {
				rt = mid-1;
			}
		}
		return answer;
	}

	private int count(int[] arr, int mid) {
		int cnt = 1; 
		// 무조건 첫 번째 마구간에는 배치했다.
		int ep = arr[0]; // 이전 마구간 배치 위치
		//i도 그래서 1부터
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-ep >= mid ) {
				cnt ++;
				ep = arr[i];
			}
		}
		
		return cnt;
	}

	public static void main(String[] args){
		Main06_10 T = new Main06_10();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int c=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solution(n, c, arr));
	}
}