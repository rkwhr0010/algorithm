package algorithm03_04;

import java.util.*;
class Main {	
	public int solution(int n, int m, int[] arr){
		//100 개 합 100 경우의 수
		int answer=0;
		
		for(int rt=0,sum=0,lt=0; rt<arr.length;) {
			//핵심은 값에 변화에 민감하게 반응하여, 모든 변화에 검증로직을 태우는 것이다.
			//증감 후에는 경계값에 이르러 rt<arr.length에 걸려 100인 데도 카운트를 못할 수도 있으므로 조심
			if(sum<m) {
				sum+= arr[rt++];
				//이게 없으면 경계값에서 만약 100이 더 있을 경우 누락이된다. rt<arr.length
				if(sum==m) {
					answer++;
					sum-=arr[lt++];
				}
			}else if(sum==m) {
				answer++;
				sum-=arr[lt++];
			} else {
				sum-=arr[lt++];
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(n, m, arr));
	}
}