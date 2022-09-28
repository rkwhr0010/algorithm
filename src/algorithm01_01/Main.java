package algorithm01_01;


import java.util.*;
// 문자찾기
public class Main {
	public int solution(String str, char t){
		return (int) str.chars().filter(c -> Character.toUpperCase(c) == Character.toUpperCase(t)).count();
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		char c=kb.next().charAt(0);
		System.out.print(T.solution(str, c));
	}
}