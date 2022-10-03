package algorithm02_02;


import java.util.*;
class Main {	
	
	public int solution(int n, int[] arr){
		int answer = 0;
		int prev = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			if( Integer.compare(prev , arr[i]) == -1  ) {
				answer++;
				prev = arr[i];
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, arr));
	}
}


