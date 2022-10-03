package algorithm02_11;

import java.util.*;
import java.util.Map.Entry;
class Main {	
	public int solution(int n, int[][] arr){
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for(int i = 1 ; i < arr.length;i++) {
			map.put(i,new HashSet<Integer>());
		}
		for(int i=1;i<arr.length;i++) {
			Set set = map.get(i);
			for(int j=1; j < arr[i].length; j++) {
				int ban = arr[i][j];
				for(int z=1;z<arr.length;z++) {
					if(ban == arr[z][j]) {
						set.add(z);
					}
				}
			}
		}
		Entry<Integer, HashSet<Integer>> entry = map.entrySet()
		   .stream()
		   .reduce((e1,e2)->{
			   if(e1.getValue().size()<e2.getValue().size() ) {
				   return e2;
			   }else {
				   return e1;
			   }
		   }).get();
		return entry.getKey();
	}

	public static void main(String[] args){
		Main T = new Main();
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