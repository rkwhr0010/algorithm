package algorithm01_06;

import java.util.Scanner;
//중복문자제거
public class Main {
	public String solution(String str){
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