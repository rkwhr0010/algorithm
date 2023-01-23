package algorithm05;

import java.util.*;
//쇠막대기
class Main05_05 {	
	public int solution(String str){
		int cnt=0;
		Stack<Character> stack = new Stack<Character>();
		char cha = ' ';
		for(int i =0;i<str.length();i++) {
			cha = str.charAt(i);
			if(cha == '(') {
				stack.push(cha);
				
			} else {
				stack.pop();
				if(str.charAt(i-1)=='(') {
					cnt+= stack.size();
				} else {
					cnt++;
				}
				
			}
			
		}
		
		return cnt;
	}
	public static void main(String[] args){
		Main05_05 T = new Main05_05();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));
	}
}