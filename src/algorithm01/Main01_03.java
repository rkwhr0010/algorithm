package algorithm01;

import java.util.*;
import java.util.stream.Stream;
//문장 속 단어
public class Main01_03 {
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
		Main01_03 T = new Main01_03();
		Scanner kb = new Scanner(System.in);
		String str=kb.nextLine();
		System.out.print(T.solution(str));
		kb.close();
	}
}