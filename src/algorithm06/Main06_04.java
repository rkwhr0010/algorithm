package algorithm06;
import java.util.*;
//Least Recently Used
class Main06_04 {	
	public int[] solution(int size, int n, int[] arr){
		int[] cache = new int[size];
		
		//전체 작업을 순회
		for(int i=0;i< arr.length;i++) {
			int tmpIndex = -1;
			int value = arr[i];
			
			//캐시에 이미 존재하는지
			for(int j=0;j<cache.length;j++) {
				if(cache[j] == value) {
					tmpIndex=j;
					break;
				}
			}
			//캐시에 존재할 경우 그 자리를 제외하고 뒤로 밀기
			int j = tmpIndex != -1 ? tmpIndex : cache.length-1;
			for(; 0<j;j--) {
				cache[j] = cache[j-1];
			}
			cache[0] = arr[i];
			
		}
		return cache;
	}
	public static void main(String[] args){
		Main06_04 T = new Main06_04();
		Scanner kb = new Scanner(System.in);
		int s=kb.nextInt();
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solution(s, n, arr)) System.out.print(x+" ");
	}
}
/*
5 9
1 2 3 2 6 2 3 5 7
*/