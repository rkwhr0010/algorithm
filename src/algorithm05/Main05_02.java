package algorithm05;

import java.util.*;
//괄호문자제거
class Main05_02 {	
	public String solution(String str){
		String answer="";
		Stack<Character> stack = new Stack<Character>();
		/*
		for(char cha : str.toCharArray()) {
			if(cha=='(') stack.push(cha);
			else if(cha==')'&&!stack.isEmpty() &&stack.peek()=='(') {
				stack.pop();
			}else if(stack.isEmpty()) {
				answer+=cha;
			}
		}
		*/
		for(char cha : str.toCharArray()) {
			if(cha==')') {
				while(!stack.isEmpty()&&stack.pop() != '(');
			} else {
				stack.push(cha);
			}
		}
		for(char cha : stack) answer+=cha;
		
		return answer;
	}

	public static void main(String[] args){
		Main05_02 T = new Main05_02();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}