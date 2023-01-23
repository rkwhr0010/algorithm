package algorithm02;

import java.util.*;
//소수 에라토스테네스의 체
class Main02_05 {	
	public static void main(String[] args){
		Main02_05 T = new Main02_05();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		System.out.println(T.solution(n));
		
	}

	private int solution(int n) {
		int answer = 0;
		int[] count = new int[n+1];
		for(int i = 2; i<= n ; i++) {
			if(count[i] == 0) {
				answer++;
				for(int j=i ; j<=n; j=j+i) {
					count[j] = 1;
				}
			}
		}
		System.out.println(Arrays.toString(count));
		return answer;
	}
}
