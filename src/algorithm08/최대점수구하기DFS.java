package algorithm08;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
class 최대점수구하기DFS{
	static int answer=Integer.MIN_VALUE
			, n =5 /*문제 수*/
			, m =50/*제한 시간*/
			, sumN  /*문제 합*/
			, sumM; /*제한 시간 합*/
	
	static int[] nArr,mArr;
	
	//L은 레벨로 깊이라고 이해하면 된다.
	static void DFS3(int L) {
		//제한 시간을 넘기면 더 이상 볼 필요없다.
		if(sumM>m) return;
		
		//모든 노드 순회 완료
		if(L==n) {
			answer = Math.max(answer,sumN);
		//아직 순회할 것이 남았다.
		} else {
			//더 했을 때
			sumN+=nArr[L];
			sumM+=mArr[L];

			DFS3(L+1);
			//안 더했을 때
			sumN-=nArr[L];
			sumM-=mArr[L];
			DFS3(L+1);
		}
	}
	
	public void DFS(int L, int sum, int time, int[] ps, int[] pt){
		if(time>m) return;
		if(L==n){
			answer=Math.max(answer, sum);
		}
		else{
			DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
			DFS(L+1, sum, time, ps, pt);
		}
	}

	public static void main(String[] args){
		nArr=getIntArray(1, 15, n);
		mArr=getIntArray(10, 20, n);
		System.out.println(Arrays.toString(nArr));
		System.out.println(Arrays.toString(mArr));
		
//		T.DFS(0, 0, 0, a, b);
		DFS3(0);
		System.out.println("제한 시간 내 최대 문제 "+ answer);
	}
	
	static int[] getIntArray(int start, int end, int limit) {
		return ThreadLocalRandom.current()
				.ints(start,end+1)
				.distinct()
				.limit(limit)
				.toArray();
	}
	
	
	
	
	
}