package algorithm02;


import java.util.*;
import java.util.Map.Entry;
class Main02_11 {	
	public int solution(int n, int[][] arr){
		int answer = 0;
		int max = Integer.MIN_VALUE;
		
		//기준 학생 x 축
		for(int i=1;i<=n;i++) {
			int count = 0;
			//비교할 학생 x 축
			for(int j=1;j<=n;j++) {
				//학년 배열 y축 기준학생과 비교할 학생은 y축은 공유한다.
				for(int k=1;k<6;k++) {
					//나 자신도 포함되지만, 모든 학생이 동등한 조건이므로 상관없다.
					if(arr[i][k]==arr[j][k]) {
						count++;
						break;
					}
				}
			}
			if(max<count) {
				max = count;
				answer = i;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main02_11 T = new Main02_11();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] arr=new int[n+1][6];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=5; j++){
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
	}
}