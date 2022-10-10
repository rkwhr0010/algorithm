package algorithm02;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Main02_12 {	
	//n 학생수
	//m 시험수
	public int solution(int n, int m, int[][] arr){
		int answer = 0;
		// n 학생수 , m 시험 수

		// 맨토 인덱스
		for (int i = 1; i <= n; i++) {
			// 맨티 인덱스
			for (int j = 1; j <= n; j++) {// i,j 포문으로 (i,j)짝을 만듦
				int cnt = 0;
				// 시험 수 인덱스
				for (int k = 0; k < m; k++) {
					int pi = 0;
					int pj = 0;

					// 시험 등수, 등수기 때문에 학생 수와 같다.
					for (int s = 0; s < n; s++) {
						// i번 학생의 등수 , 맨토
						// 실제 s번 등수의 학생 번호
						if (arr[k][s] == i) {
							pi = s;
						}
						// j번 학생의 등수 , 맨티
						// 실제 s번 등수의 학생 번호
						if (arr[k][s] == j) {
							pj = s;

						}
					}//s
					//구한 등수값은 당연히 맨토가 작아야한다.
					//나와 나를 비교해도 상관없다. 참이 될 수 없기 때문
					if(pi<pj) cnt++;
				}//k
				//맨토,맨티 경우의 수를 전부 검증한 횟수와 카운트 수가 같으면
				//모든 시험에서 맨토가 더 잘했다는 뜻으로 맨토가 될 수 있다.
				if(cnt==m) {
					answer++;
				}
			}//j
		}//i

		return answer;
	}

	public static void main(String[] args){
		Main02_12 T = new Main02_12();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[][] arr=new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, m, arr));
	}
}