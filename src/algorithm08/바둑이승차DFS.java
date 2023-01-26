package algorithm08;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
class 바둑이승차DFS{
	
	static int answer=Integer.MIN_VALUE, c, n;
	
	static int[] arr;
	static int sum;
	
	
	void DFS2(int L) {
		if(sum>c) return;
		if(n==L) {
			System.out.println(answer+"    "+sum);
			answer = Integer.max(answer, sum);
			return ;
		} else {
			sum+=arr[L];//가산 했을때
			DFS2(L+1);
			sum-=arr[L];//가산 안했을때
			DFS2(L+1);
		}
	}
	
	
	public void DFS(int L, int sum, int[] arr){
		if(sum>c) return;
		if(L==n){
			answer=Math.max(answer, sum);
		}
		else{
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}	
	}
	
	public static void main(String[] args){
		바둑이승차DFS T = new 바둑이승차DFS();
		arr= ThreadLocalRandom.current()
			.ints(10, 100)
			.distinct()
			.limit(5)
			.toArray();
		
		//제한 무게
		c = Arrays.stream(arr).sum()/2;
		n=arr.length; //받은 요소 수
		System.out.println(Arrays.toString(arr));
		T.DFS2(0);
		System.out.println("제한무게 "+c);
		System.out.println("최대무게 "+answer);
	}
}
