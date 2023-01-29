package algorithm08;

import java.util.*;


class 중복순열DFS{
	static int[] pm;
	static int n //수 크기
		     , m// m 배열 길이
	         , cnt;
	static void DFS3(int L) {
		System.out.println(cnt+" "+Arrays.toString(pm));
		if(L==m) {
			return;
		}else {
			for (int i = 1; i <= n; i++) {
				cnt++;
				pm[L] = i;
				DFS3(L+1);
			}
		}
	}
	
	public static void main(String[] args){
		n=3;
		m=2;
		pm=new int[m];
		DFS3(0);
	}
}