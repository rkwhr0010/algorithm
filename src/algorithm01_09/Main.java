package algorithm01_09;

import java.util.*;
//숫자 추출
class Main {	
	public int solution(String s){
		s = s.toLowerCase().replaceAll("[a-z]", "");
		System.out.println(s);
		return Integer.valueOf(s.chars()
				.filter(Character::isDigit)
				.mapToObj(num -> String.valueOf((char)num))
				.reduce("", String::concat));
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
	}
}