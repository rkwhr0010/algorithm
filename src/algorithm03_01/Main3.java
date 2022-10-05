package algorithm03_01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Main3 {	
	public List<Integer> solution(int n, int m, int[] a, int[] b){
		List<Integer> collect = IntStream.concat(IntStream.of(a), IntStream.of(b))
		         .sorted()
		         .boxed()
		         .collect(Collectors.toList());
		return collect;
	}

	public static void main(String[] args){
		Main3 T = new Main3();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
		}
		int m=kb.nextInt();
		int[] b=new int[m];
		for(int i=0; i<m; i++){
			b[i]=kb.nextInt();
		}
		for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");
	}
}