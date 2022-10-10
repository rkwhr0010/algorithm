package algorithm01;

import java.util.*;
// 가장 짧은 문자거리
class Main01_11 {	
	public int[] solution(String s, char t){
		int[] answer=new int[s.length()];
		Arrays.fill(answer, Integer.MAX_VALUE);
	    char[] cs = s.toCharArray();
		
	    for(int i =0;i<cs.length;i++) {
	    	if(cs[i]==t) {
	    		answer[i] = 0;
	    		prev(answer, i);
	    		forward(answer, i);
	    	}
	    }
		return answer;
	}
	private void forward(int[] answer, int index) {
		
		for(int i=index, num=0;i<answer.length;i++,num++) {
			if(answer[i]> num ) {
				answer[i] = num ;
			}
		}
	}
	private void prev(int[] answer, int index) {
		for(int i=0;i<index;i++) {
			if(answer[i]> index-i ) {
				answer[i] = index-i ;
			}
		}
	}
	
	public static void main(String[] args){
		Main01_11 T = new Main01_11();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		char c=kb.next().charAt(0);
		for(int x : T.solution(str, c)){
			System.out.print(x+" ");
		}
	}
}