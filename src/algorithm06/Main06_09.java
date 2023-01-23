package algorithm06;

import java.util.*;
//뮤직비디오(결정알고리즘)
/*
10 3
6 5 8 5 6 8 7 6 6 7 
24
 */
class Main06_09 {
	public int solution(int n, int m, int[] arr){
		int answer=0;
		Arrays.sort(arr);
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			if(count(arr, mid) <= m) {
				answer = mid;
				rt = mid-1;
			}else {
				lt = mid+1;
			}
		}
		return answer;
	}
	private int count(int[] arr, int mid) {
		int sum = 0, count =1;
		for(int num : arr) {
			sum+=num;
			if(mid<sum) {
				sum = num;
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args){
		Main06_09 T = new Main06_09();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solution(n, m, arr));
	}
}