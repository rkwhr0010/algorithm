package algorithm05;

import java.util.*;
class Main05_01 {	
	public String solution(String str){
		String answer="YES";
		Stack<Character> stack = new Stack<Character>();
		
		for(char cha : str.toCharArray()) {
			if(cha=='(') stack.push(cha);
			else if(cha==')'&&!stack.isEmpty() &&stack.peek()=='(') {
				stack.pop();
			}else {
				return "NO";
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		Main05_01 T = new Main05_01();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}