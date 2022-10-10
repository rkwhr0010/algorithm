package algorithm01;

import java.util.Scanner;
import java.util.stream.Stream;
//단어 뒤집기
public class Main01_04 {
	
	public static void main(String[] args){
		Main01_04 T = new Main01_04();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		String[] str=new String[n];
		for(int i=0; i<n; i++){
			str[i]=kb.next();
		}
		for(Object x : T.solution(n, str)){
			System.out.println(x);
		}
	}
	private Object[] solution(int n, String[] str) {
		for(String string : str) {
			char[] charArray = string.toCharArray();
			int lt = 0 ; 
			int rt = charArray.length-1;
			while(lt<rt) {
				char tmp = charArray[lt];
				charArray[lt] = charArray[rt];
				charArray[rt] = tmp;
				lt ++;
				rt --;
			}
		}
		return Stream.of(str)
			      .map(arg-> {
				    	 char[] charArray = arg.toCharArray();
				    	 StringBuilder sb = new StringBuilder();
				    	 for(int i = charArray.length-1 ; i>=0 ;i--) {
				    		 sb.append(charArray[i]);
				    	 }
				    	 return sb.toString();
				      })
			      .toArray();
	}
}