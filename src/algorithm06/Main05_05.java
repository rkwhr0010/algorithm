package algorithm06;

import java.util.*;
//중복체크
class Main05_05 {
	public String solution(int n, int[] arr) {
		String answer = "U";
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++) {
			if(hs.contains(arr[i])) {
				return "D";
			}else {
				hs.add(arr[i]);
			}
		}
		return answer;
	}
/*
 * 
8
20 25 52 30 39 33 43 33

 */
	public static void main(String[] args) {
		Main05_05 T = new Main05_05();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = kb.nextInt();
		System.out.println(T.solution(n, arr));
	}
}