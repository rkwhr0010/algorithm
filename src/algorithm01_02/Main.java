package algorithm01_02;

import java.util.*;
//대소문자변환
public class Main {
	public String solution(String str){
		return str.chars()
				  .map(c -> Character.isLowerCase(c)?Character.toUpperCase(c) : Character.toLowerCase(c) )
				  .mapToObj(c -> String.valueOf((char)c))
				  .reduce("", String::concat);
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.print(T.solution(str));
		kb.close();
	}
}