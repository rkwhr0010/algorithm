package algorithm01_10;

import java.util.*;

//암호
class Main {	
	public String solution(int n, String s){
		String answer="";
		
		String reduce = s.chars()
		  .map( c-> c == '#' ? '1' : '0')
		  .mapToObj(c-> ""+(char)c)
		  .reduce("", String::concat);
		
		int acc = reduce.length()/n;
		int start = 0;
		int last = acc;
		for(int i=0;i<n;i++) {
			char tmp = (char)(Integer.valueOf(reduce.substring(start, last), 2).intValue());
			answer+=tmp;
			start += acc;
			last += acc;
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String str=kb.next();
		System.out.println(T.solution(n, str));
	}
}