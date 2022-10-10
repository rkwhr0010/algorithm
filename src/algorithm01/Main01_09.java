package algorithm01;

import java.util.*;
//숫자 추출
class Main01_09 {	
	public int solution(String s){
		s = s.toLowerCase().replaceAll("[a-z]", "");
		System.out.println(s);
		return Integer.valueOf(s.chars()
				.filter(Character::isDigit)
				.mapToObj(num -> String.valueOf((char)num))
				.reduce("", String::concat));
	}

	public static void main(String[] args){
		Main01_09 T = new Main01_09();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}