package algorithm06;
import java.util.*;
//이분 검색
//조건 반드시 정렬된 상태여야 함
class Main05_08 {
	public int solution(int n, int m, int[] arr){
		Arrays.sort(arr);
		int lt=0,rt=arr.length-1,answer=0;
		while(lt<=rt) {
			int mid = (rt+lt)/2;
			if(m==arr[mid]) {
				answer = mid+1;
				break;
			}else if(m<arr[mid]) {
				rt = mid-1;
			}else {
				lt = mid +1;
			}
		}
		return answer;
	}
	public static void main(String[] args){
		Main05_08 T = new Main05_08();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		System.out.println(T.solution(n, m, arr));
	}
}
