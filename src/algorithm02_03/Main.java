package algorithm02_03;

import java.util.*;
class Main {	
	public String solution(int n, int[] a, int[] b){
		StringBuilder answer= new StringBuilder("");
		//1:가위, 2:바위, 3:보로 정하겠습니다.
		for(int i=0;i<n;i++) {
			if(a[i]==b[i]) {
				answer.append("D");
				continue;
			}
			int result = Math.abs(a[i]-b[i]);
			if(result>1) {
				if(Integer.compare(a[i], b[i])>0) {
					answer.append("B");
				}else {
					answer.append("A");
				}
			}else {
				if(Integer.compare(a[i], b[i])>0) {
					answer.append("A");
				}else {
					answer.append("B");
				}
			}
		}
		return answer.toString();
	}
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] a=new int[n];
		int[] b=new int[n];
		for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
		}
		for(int i=0; i<n; i++){
			b[i]=kb.nextInt();
		}
		for(char x : T.solution(n, a, b).toCharArray()) System.out.println(x);
	}
}


