package algorithm04;

import java.util.*;
class Main4_04 {	
	public int solution(String a, String b){
		int answer=0;
		HashMap<Character, Integer> inputMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		//초기화
		for(int i=0;i<b.length()-1;i++) {
			char tmp1 = a.charAt(i);
			char tmp2 = b.charAt(i);
			inputMap.put(tmp1, inputMap.getOrDefault(tmp1, 0)+1 );
			map.put(tmp2, map.getOrDefault(tmp2, 0)+1 );
		}
		map.put(b.charAt(b.length()-1), map.getOrDefault(b.charAt(b.length()-1), 0)+1 );
		
		for(int lt=0, rt=b.length()-1 ;rt<a.length();rt++) {
			char tmp = a.charAt(rt);
			//1. 추가
			inputMap.put(tmp, inputMap.getOrDefault(tmp, 0)+1);
			
			//2. 검증
			/*
			boolean flag= true;
			for(Character cha : map.keySet()) {
				//키 검증
				if(!inputMap.containsKey(cha)) {
					flag=false;
					break;
				}
				//개수 검증
				if(!(inputMap.get(cha) == map.get(cha))) {
					flag=false;
					break;
				}
			}
			if(flag) {
				answer++;
			}
			*/
			if(inputMap.equals(map)) {
				answer++;
			}
			
			//3. 삭제&수정&추가
			tmp = a.charAt(lt);
			inputMap.put(tmp, inputMap.get(tmp)-1 );
			
			if(inputMap.get(tmp)==0 ) {
				inputMap.remove(tmp);
			}
			lt++;
		}
		return answer;
	}

	public static void main(String[] args){
		Main4_04 T = new Main4_04();
		Scanner kb = new Scanner(System.in);
		String a=kb.next();
		String b=kb.next();
		System.out.print(T.solution(a, b));
	}
}