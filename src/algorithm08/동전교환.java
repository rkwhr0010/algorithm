package algorithm08;

import java.util.Arrays;
import java.util.Collections;

class 동전교환{
	static int n, m, answer=Integer.MAX_VALUE;
	static int sum;
	static int[] arr;
	static Integer[] arr2;
	static boolean flag;
	
	
	  
	static void DFS3(int L) {
		if(flag) return;
		if(sum>m) return; // 목표값보다 크면 안된다.
		if(L>=answer) return;
		if(sum==m) {
			answer = Math.min(answer, L);
			flag = true;
			return;
		}else {
			for (int i = arr.length-1; i>=0; i--) {
				sum+=arr[i];
				DFS3(L+1);
				sum-=arr[i];
			}
		}
	}
	
	static void DFS2(int L) {
		if(flag) return;
		if(sum>m) return;
		if(L>=answer) return;
		if(sum==m) {
			answer = Math.min(answer, L);
			flag = true;
			return;
		}else {
			for (int j = 0; j < arr2.length; j++) {
				sum+= arr2[j];
				DFS2(L+1);
				sum-= arr2[j];
			}
		}
	}
	
	public static void DFS(int L, int sum, Integer[] arr){
		if(sum>m) return;
		if(L>=answer) return;
		if(sum==m){
			answer=Math.min(answer, L);
		}
		else{
			for(int i=0; i<n; i++){
				DFS(L+1, sum+arr[i], arr);
			}
		}	
	}
	
	public static void main(String[] args){
		arr= new int[] {1,2,5};
		arr2 = Arrays.stream(arr.clone()).boxed().toArray(Integer[]::new);
		n=3;
		m=223 ;
		DFS3(0);
		System.out.println(answer);
		
		
		flag = false;
		sum = 0;
		answer = 1231;
		Arrays.sort(arr2, Collections.reverseOrder());
		DFS2(0);
		System.out.println(answer);
		
	}
}