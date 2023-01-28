package algorithm08;

import java.util.Arrays;

class 순열구하기{
	static int[] pm, ch, arr;
	static int n, m;
	static int[][] chArr ;
	
	static void DFS2(int L){
		if(m==L) {
			for(int x : pm) System.out.print(x+" ");
			System.out.println();
		}else {
			for (int i = 0; i < arr.length; i++) {
				if(ch[i]==0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS2(L+1);
					ch[i] = 0;
				}
			}
		}
	}
	static void DFS3(int L){
		if(m==L) {
			for(int x : pm) System.out.print(x+" ");
			System.out.println();
		}else {
			for (int i = 0; i < arr.length; i++) {
				if(chArr[1][i]==0) {
					chArr[1][i] = 1;
					pm[L] = chArr[0][i];
					DFS3(L+1);
					chArr[1][i] = 0;
				}
			}
		}
	}
	
	static void DFS4(int L){
		if(m==L) {
			for(int x : ChArr.pm) System.out.print(x+" ");
			System.out.println();
		}else {
			for (int i = 0; i < arr.length; i++) {
				if(ChArr.ch[i]==0) {
					ChArr.ch[i] = 1;
					ChArr.pm[L] = arr[i];
					DFS4(L+1);
					ChArr.ch[i] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		n=3;
		m=2;
		arr= new int[] {3,6,9};
		ch=new int[n];
		pm=new int[m];
		
		chArr = new int[2][3];
		chArr[0] = arr.clone(); // 값이 저장된 배열
		chArr[1] = ch.clone();  // 값사용 여부 체크배열
		
		DFS2(0);
		Arrays.fill(pm, 0);
		System.out.println();
		DFS3(0);
		System.out.println();
		DFS4(0);
		
	}
	
	
	static class ChArr{
		static int[] pm, ch;
		static {
			ch=new int[n];  // 값이 저장된 배열   
			pm=new int[m];  // 값사용 여부 체크배열 
		}
	}
}