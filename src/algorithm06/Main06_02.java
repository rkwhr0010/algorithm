package algorithm06;
import java.util.*;
class Main06_02 {	
	//규칙1, 뒷자리를 제일 큰 수로 채우면서 줄여간다. 
	//규칙2, 나보다 큰 수를 만나면 교체하여 끝까지 순회한다.
	// 결과적으로 제일 끝자리부터 채워간다.
	public int[] solution(int n, int[] arr){
		//반복 횟수
		for(int i=0;i<arr.length-1;i++) {
			//정렬을하는 반복자
			for(int j=1;j<arr.length-i;j++) {
				if(arr[j-1]>arr[j]) {
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args){
		Main06_02 T = new Main06_02();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solution(n, arr)) System.out.print(x+" ");
	}
}