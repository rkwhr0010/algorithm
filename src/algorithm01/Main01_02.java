package algorithm01;

import java.util.*;
//대소문자변환
public class Main01_02 {
	public String solution(String str){
		return str.chars()
				  .map(c -> Character.isLowerCase(c)?Character.toUpperCase(c) : Character.toLowerCase(c) )
				  .mapToObj(c -> String.valueOf((char)c))
				  .reduce("", String::concat);
	}
	public static void main(String[] args){
		Main01_02 T = new Main01_02();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
		kb.close();
	}
}