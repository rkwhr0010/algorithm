package algorithm01;


import java.util.*;
// 문자찾기
public class Main01_01 {
	public int solution(String str, char t){
		return (int) str.chars().filter(c -> Character.toUpperCase(c) == Character.toUpperCase(t)).count();
	}
	public static void main(String[] args){
		Main01_01 T = new Main01_01();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		char c=kb.next().charAt(0);
		System.out.print(T.solution(str, c));
	}
}