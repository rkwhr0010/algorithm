package algorithm02_07;
import java.util.*;

class Main {	
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

	private int solution(int n, int[] arr) {
		int answer=0;
		int point = 1;
		for(int i=0;i<n;i++) {
			if(arr[i] == 1 ) {
				answer += point++;
				continue;
			}
			point=1;
		}
		
		return answer;
	}
}
