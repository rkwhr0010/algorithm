package algorithm03_03;


import java.util.*;
class Main {	
	public int solution(int n, int k, int[] arr){
		int max = 0;
		for(int i = 0 ; i < k;i++) {
			max+=arr[i];
		}
		int tmp = max;
		for(int i = k ; i < arr.length;i++) {
			tmp = tmp - arr[i-k] + arr[i];
			max = max>=tmp?max:tmp;
		}
		
		return max;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, k, arr));
	}
}