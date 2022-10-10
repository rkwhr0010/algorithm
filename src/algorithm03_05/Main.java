package algorithm03_05;

import java.util.*;
import java.util.stream.IntStream;
// n 값이 될 수 있는 연속된 자연 수 합 구하기
class Main {
	public int solution(int n) {
		int answer = 0, sum = 0;
		int m = n / 2 + 1; //2개 이상의 연속된 자연수의 합은 절반 정도만 필요
		int[] arr = IntStream.rangeClosed(1, m).toArray();
		for (int rt = 0,lt = 0; rt < m; rt++ ) {
			sum+= arr[rt];
			while(n<=sum) {
				if(sum==n) {
					answer++;
					sum-=arr[lt++];
				}else {
					sum-=arr[lt++];
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.print(T.solution(n));
	}
}