package algorithm02;

import java.util.*;
//피보나치
class Main02_04 {	
	public static void main(String[] args){
		Main02_04 T = new Main02_04();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		for(int x :T.solution(n)) System.out.print(x+" ");
		
		
	}
	public int[] solution(int n){
		int[] answer = new int[n];
		answer[0] = 1;
		answer[1] = 1;
		for(int i=2;i<n;i++) {
			answer[i]=answer[i-2]+ answer[i-1];
		}
		return answer;
	}
}
