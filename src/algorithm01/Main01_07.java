package algorithm01;

import java.util.*;
//회문문자열
class Main01_07 {	
	
	public String solution(String str){
		String answer="YES";
		int len = str.length();
		str = str.toUpperCase();
		for(int i=0;i<len/2;i++) {
			if(str.charAt(i) !=  str.charAt(len-1-i)) {
				return "NO";
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main01_07 T = new Main01_07();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}

