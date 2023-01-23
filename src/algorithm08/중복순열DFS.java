package algorithm08;
import java.util.*;


class 중복순열DFS{
	static int[] pm;
	static int n //수 크기
		, m;// 몇번 뽑을지
	
	
	
	public void DFS2(int L){
		if(L==m) {
			for(int num : pm) System.out.print(num+ " ");
			System.out.println();
		}else {
			for (int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS2(L+1);
				
			}
			
			
		}
		
	}
	
	public void DFS(int L){
		if(L==m){
			for(int x : pm) System.out.print(x+" ");
			System.out.println();
		}
		else{
			for(int i=1; i<=n; i++){
				pm[L]=i;
				DFS(L+1);
			}
		}
	}
	public static void main(String[] args){
		중복순열DFS T = new 중복순열DFS();
		Scanner kb = new Scanner(System.in);
		n=3;
		m=2;
		pm=new int[m];
		T.DFS2(0);
	}
}