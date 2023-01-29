package algorithm08;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

//집합 요소를 두 개 부분 집합으로 나눴을 때
//두 집합은 서로소 관계며 값이 같을 경우 YES 출력
class 합이같은부분집합DFS{
	static String answer="NO";
	static int n, total=0;
	boolean flag=false;
	static int[] ch ;
	static int[] arr;
	static int sum = 0;
	static Stack<Integer> stack = new Stack<Integer>();
	static int pushCnt = 0;
	static int popCnt = 0;
	
	
	void DFS2(int L) {
		if(flag||L==n||total/2<sum) return;
		
		if(sum==total-sum) {
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			list.removeAll(stack);
			System.out.println("집합 "+Arrays.toString(arr));
			System.out.println("서로소 집합1 "+stack);
			System.out.println("서로소 집합2 "+list);
			System.out.println("종합 "+total);
			
			System.out.println("푸쉬 수 "+pushCnt);
			System.out.println("팝 수 "+popCnt);
			
			flag = true;
			answer = "YES";
			return;
		} else {
			sum += arr[L];
			stack.push(arr[L]);
			pushCnt++;
			DFS2(L+1);
			sum -= arr[L];
			stack.pop();
			popCnt++;
			DFS2(L+1);
		}
		
	}
	
	public void DFS(int L, int sum, int[] arr){
		if(flag) return;
		if(sum>total/2) return;
		if(L==n){
			if((total-sum)==sum){
				answer="YES";
				flag=true;
			}	
		}
		else{
			DFS(L+1, sum+arr[L], arr);
			DFS(L+1, sum, arr);
		}
	}
	public static void main(String[] args){
		합이같은부분집합DFS T = new 합이같은부분집합DFS();
		//집합 요소
		arr = ThreadLocalRandom.current()
			.ints(1, 10)
			.distinct()
			.limit(5)
			.toArray();
		
		n= arr.length ;
		ch= new int[n];
		total = Arrays.stream(arr).sum();
		T.DFS2(0);
		System.out.println(answer);
	}
}