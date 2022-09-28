package algorithm01_03;

import java.util.*;
import java.util.stream.Stream;
//문장 속 단어
public class Main {
	public String solution(String str){
		String[] split = str.split(" ");
		Integer max = Stream.of(split)
		      .map(String::length)
		      .max(Integer::compare)
		      .orElse(-1);
		for(String string : split) {
			if(string.length()==max ) {
				return string;
			}
		}
		return "";
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
		kb.close();
	}
}