package algorithm05;

import java.util.*;
//후위연산
class Main05_04 {	
	public int solution(String str){
		int answer=0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(char cha : str.toCharArray()) {
			int lt = 0;
			int rt = 0;
			if(!Character.isDigit(cha)) {
//			if(cha =='+'||cha =='-'||cha =='/'||cha =='*') {
				rt = stack.pop();
				lt = stack.pop();
				answer = cha=='+'? Integer.sum(lt, rt) 
						:cha=='-'? Math.subtractExact(lt, rt)
						:cha=='/'? Math.floorDiv(lt, rt) : Math.multiplyExact(lt, rt);
				stack.push(answer);
			}else {
				stack.push(cha-'0');
			}
		}
		
		
		return answer;
	}
	public static void main(String[] args){
		Main05_04 T = new Main05_04();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}

