package algorithm01_06;

import java.util.Scanner;
//중복문자제거
public class Main {
	public String solution(String str){
		String answer = "";
		for(int i = 0 ; i< str.length() ; i++) {
			// indexOf()는 가장 앞에 특정 문자열 위치를 반환한다.
			// 따라서 i 위치와 i위치 값의 indexOf() 가 같다면 처음 발견한 것이다.
			if(str.indexOf( str.charAt(i) ) == i ) {
				answer += str.charAt(i);
			}
		}
		
		return str.chars()
				   .distinct()
				   .mapToObj(c-> String.valueOf((char)c))
				   .reduce("", String::concat);
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}