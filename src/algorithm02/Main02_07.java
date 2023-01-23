package algorithm02;
import java.util.*;

class Main02_07 {	
	public static void main(String[] args){
		Main02_07 T = new Main02_07();
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
