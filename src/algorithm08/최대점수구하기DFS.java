package algorithm08;

import java.util.*;
class 최대점수구하기DFS{
	static int answer=Integer.MIN_VALUE
			, n /*문제 수*/
			, m /*제한 시간*/
			, sumA
			, sumB;
	boolean flag=false;
	
	static int[] a,b;
	
	void DFS2(int L) {
		if(sumB>m) return;
		if(n==L) {
			
			answer = Math.max(answer, sumA);
			
		} else {
			sumA+=a[L];
			sumB+=b[L];
			DFS2(L+1);
			sumA-=a[L];
			sumB-=b[L];
			DFS2(L+1);
		}
		
	}
	
	
	
	public void DFS(int L, int sum, int time, int[] ps, int[] pt){
		if(time>m) return;
		if(L==n){
			answer=Math.max(answer, sum);
		}
		else{
			DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
			DFS(L+1, sum, time, ps, pt);
		}
	}

	public static void main(String[] args){
		최대점수구하기DFS T = new 최대점수구하기DFS();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		a=new int[n];
		b=new int[n];
		for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
			b[i]=kb.nextInt();
		}
//		T.DFS(0, 0, 0, a, b);
		T.DFS2(0);
		System.out.println(answer);
	}
}