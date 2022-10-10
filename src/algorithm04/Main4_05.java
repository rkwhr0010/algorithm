package algorithm04;

import java.util.*;
class Main4_05 {	
	public int solution(int[] arr, int n, int k){
		TreeSet<Integer> set = new TreeSet<>((a,b)->Integer.compare(b, a));
		
		for(int i = 0;i<n;i++) {
			int tmp1 = arr[i];
			for(int j=i+1;j<n;j++) {
				int tmp2 = arr[j];
				for(int z=j+1;z<n;z++) {
					int tmp3= arr[z];
					int sum = tmp1+tmp2+tmp3;
					set.add(sum);
				}
			}
		}
		if(set.size()<k) {
			return -1;
		}
		int cnt = 1;
		int sum =-1;
		for(Iterator<Integer> it = set.iterator();it.hasNext() ;cnt++) {
			sum = it.next();
			if(cnt==k) return sum;
		}
		return -1;
	}

	public static void main(String[] args){
		Main4_05 T = new Main4_05();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.println(T.solution(arr, n, k));
	}
}