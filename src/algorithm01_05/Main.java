package algorithm01_05;

import java.util.LinkedList;
import java.util.Scanner;
//특정 문자 뒤집기
public class Main {
	public String solution(String str){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<str.length();i++) {
			if(Character.isAlphabetic(str.charAt(i))) {
				queue.add(i);
			}
		}
		int size = queue.size()/2;
		for(int i= 0 ; i< size;i++) {
			int first = queue.pollFirst();
			int last = queue.pollLast();
		    
		    char tmp = charArray[first];
		    charArray[first] = charArray[last];
		    charArray[last] = tmp; 
		}
		
		return String.valueOf(charArray);
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}