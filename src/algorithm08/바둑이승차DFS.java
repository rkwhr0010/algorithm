package algorithm08;

import java.util.*;
class 바둑이승차DFS{
	
	static int answer=Integer.MIN_VALUE, c, n;
	
	static int[] arr;
	static int sum;
	
	
	void DFS2(int L) {
		if(sum>c) return;
		if(n<=L) {
			answer = Integer.max(answer, sum);
			return ;
		} else {
			sum+=arr[L];
			DFS2(L+1);
			sum-=arr[L];
			DFS2(L+1);
		}
	}
	
	
	public void DFS(int L, int sum, int[] arr){
		if(sum>c) return;
		if(L==n){
			answer=Math.max(answer, sum);
		}
		else{
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}	
	}
	
	public static void main(String[] args){
		바둑이승차DFS T = new 바둑이승차DFS();
		Scanner kb = new Scanner(System.in);
		c=kb.nextInt();
		n=kb.nextInt();
		arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		
//		T.DFS(0, 0, arr);
		T.DFS2(0);
		
		System.out.println(answer);
	}
}
