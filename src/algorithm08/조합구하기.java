package algorithm08;

import java.util.*;
class 조합구하기{
	static int[] combi;
	static int n, m, cnt;
	
	static void DFS(int L, int s) {
		if(L==m) {//L이 m과 같다면 목표 배열 크기까지 수행 후 다시 호출된 것
			//즉, L은 배열인덱스범위 밖이다.
			cnt++;
			System.out.println(cnt+" "+"L"+L+" "+Arrays.toString(combi) +"[출력]");
			return;
		}
		for (int i = s; i <= n; i++) {
			cnt++;
			combi[L] = i;
			System.out.println(cnt+" "+"L"+L+" "+Arrays.toString(combi));
			DFS(L+1, i+1);
		}
	}
	
	
	public static void main(String[] args){
		n=5; // 최대 숫자
		m=2; // 조합배열 크기
		combi=new int[m];//조합 배열
		DFS(0, 1);//배열인덱스, 시작 숫자
	}
}