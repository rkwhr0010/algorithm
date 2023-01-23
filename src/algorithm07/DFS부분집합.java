package algorithm07;

import java.util.*;
class DFS부분집합 {
	static int n;
	static int[] ch;
	
	public void DFS(int L){
		if(L==n+1){
			String tmp="";
			for(int i=1; i<=n; i++){
				if(ch[i]==1) tmp+=(i+" ");
			}
			if(tmp.length()>0) System.out.println(tmp);
		}
		else{
			ch[L]=1;
			DFS(L+1);
			ch[L]=0;
			DFS(L+1);
		}
	}
	
	void DFS2(int L) {
		if(n+1==L) {
			String tmp = "";
			
			for (int i = 1; i < ch.length; i++) {
				tmp+= ch[i]!= 0 ?ch[i]+" " : "";
			}
			if(tmp.length()!=0)
				System.out.println(tmp);
			
			return;
		}else {
			ch[L] = 1;
			DFS(L+1);
			ch[L] = 0;
			DFS(L+1);
		}
	}

	public static void main(String[] args){
		DFS부분집합 T = new DFS부분집합();
		n=3;
		ch=new int[n+1];
		T.DFS2(1);
	}	
}
