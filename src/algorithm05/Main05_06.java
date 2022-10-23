package algorithm05;
import java.util.*;
//공주구하기
class Main05_06 {	
	public int solution(int n, int k){
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			queue.offer(i+1);
		}
		while( 1<queue.size()) {
			for(int i=0;i<k-1;i++) {
				queue.offer(queue.poll());
			}
			queue.poll();
		}
		
		
		return queue.poll();
	}
	public static void main(String[] args){
		Main05_06 T = new Main05_06();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		System.out.println(T.solution(n, k));
	}
}