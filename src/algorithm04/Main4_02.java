package algorithm04;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class Main4_02 {	
	public String solution(String s1, String s2){
		String answer="YES";
		HashMap<Character, Integer> map1=new HashMap<>();
		HashMap<Character, Integer> map2=new HashMap<>();
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		
		for(int i=0;i<cs1.length;i++) {
			map1.put(cs1[i], map1.getOrDefault(cs1[i], 0)+1);
			map2.put(cs2[i], map2.getOrDefault(cs2[i], 0)+1);
		}
		
		for(Entry<Character, Integer> entry : map1.entrySet()) {
			if(!map2.remove(entry.getKey(),entry.getValue())) {
				return "NO";
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main4_02 T = new Main4_02();
		Scanner kb = new Scanner(System.in);
		String a=kb.next();
		String b=kb.next();
		System.out.print(T.solution(a, b));
	}
}
