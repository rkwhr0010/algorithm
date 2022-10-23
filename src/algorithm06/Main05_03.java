package algorithm06;


import java.util.*;
class Main05_03 {	
	// 최대치를 높여가며 뒤부터 앞으로 정렬을 반복
	public int[] solution(int n, int[] arr){
		for(int i=1;i<arr.length;i++) {
			for(int j=i-1;0<=j;j--) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					
				}
			}
		}
		return arr;
	}
	public static void main(String[] args){
		Main05_03 T = new Main05_03();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solution(n, arr)) System.out.print(x+" ");
	}
}