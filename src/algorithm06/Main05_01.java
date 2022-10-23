package algorithm06;
import java.util.*;
//선택정렬
class Main05_01 {	
	//규칙1, 앞자리를 가장 작은 수로 채우면서 나아간다. 
	//규칙2, 나보다 작은 수를 만나면 교체하여 끝까지 순회한다.
	// 제일 중요한 것은 인덱스 위치를 저장한다는 것(작은 것)
	// 결과적으로 앞자리부터 제일 작은 수부터 채워진다.
	public int[] solution(int n, int[] arr){
		//반복횟수
		for(int i=0;i<arr.length-1;i++) {
			//정렬 반복자
			int tmp=0;
			int idx = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[idx]) {
					idx = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
			
		}
		return arr;
	}
	public static void main(String[] args){
		Main05_01 T = new Main05_01();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solution(n, arr)) System.out.print(x+" ");
	}
}