package algorithm04;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Main4_01 {	
	public char solution(int n, String s){
		HashMap<Character, Integer> countMap = new HashMap<>();
		
		IntStream.range(0, s.length())
		         .forEach(c-> countMap.put(s.charAt(c), countMap.getOrDefault(s.charAt(c),0)+1 ) );
		System.out.println(countMap);
		
		return s.chars()
				.mapToObj(c->new Character((char)c))
				.collect(Collectors.groupingBy(c->c, Collectors.counting()))
				.entrySet()
				.stream()
				.reduce((e1,e2)->e1.getValue()>=e2.getValue()?e1:e2)
				.get()
				.getKey()
				.charValue();
	}
	
	public static void containKeyPut(char key, Map<Character, Integer> countMap) {
	   	 if(countMap.containsKey(key)) {
			 countMap.put(key, countMap.get(key)+1);
		 } else {
			countMap.put(key,1);
		 }
	}
	
	public static void main(String[] args){
		Main4_01 T = new Main4_01();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String str=kb.next();
		System.out.println(T.solution(n, str));
	}
}