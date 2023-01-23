package algorithm08;

import java.util.*;
//합이같은부분집합DFS

class 합이같은부분집합DFS{
	static String answer="NO";
	static int n, total=0;
	boolean flag=false;
	static int[] ch ;
	static int[] arr;
	static int sum = 0;
	
	void DFS2(int L) {
		if(flag||n<=L||total-sum<sum) return;
		
		if(sum==total-sum) {
			flag = true;
			answer = "YES";
			return;
		} else {
			sum += arr[L];
			DFS2(L+1);
			sum -= arr[L];
			DFS2(L+1);
		}
		
	}
	
	public void DFS(int L, int sum, int[] arr){
		if(flag) return;
		if(sum>total/2) return;
		if(L==n){
			if((total-sum)==sum){
				answer="YES";
				flag=true;
			}	
		}
		else{
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
	public static void main(String[] args){
		합이같은부분집합DFS T = new 합이같은부분집합DFS();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		ch= new int[n];
		arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
			total+=arr[i];
		}
		T.DFS2(0);
		System.out.println(answer);
	}
}