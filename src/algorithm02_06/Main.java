package algorithm02_06;

import java.util.*;
class Main {	
	List<Integer> list = new ArrayList<Integer>();
	
	public ArrayList<Integer> solution(int n, int[] arr){
		ArrayList<Integer> answer = new ArrayList<Integer>();
		//숫자 뒤집기 로직
		for(int i = 0;i< n;i++) {
			int tmp = arr[i];
			int res =0;
			while(tmp>0) { //십의 자리가 존재한다.
				int t = tmp%10;    // 일의 자리 구하기
				res = res * 10 +t; // 일의 자리에 10 곱하기
				tmp = tmp/10;      // 십의 자리 구하기
			}
			arr[i] = res;
			if(isPrime(res)) answer.add(res);
			
		}
		
		return answer;
	}
	

	private boolean isPrime(int num) {
		if(num == 1) return false;
		for(int i=2 ; i<num ; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		for(int x : T.solution(n, arr)){
			System.out.print(x+" ");
		}
	}
}
