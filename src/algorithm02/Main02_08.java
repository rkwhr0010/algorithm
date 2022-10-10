package algorithm02;


import java.util.*;
class Main02_08 {	
	public int[] solution(int n, int[] arr){
		int[] answer = new int[n];
		int rank = 1;
		int cnt = 0;
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i]<arr[j]) {
					rank++;
				}
			}
			answer[i] = rank;
			rank = 1;
		}
		
		/*
		int[] array = Arrays.stream(arr)
		      .distinct()
		      .sorted()
		      .toArray();
		
		for(int j=array.length-1;j>=0;j--) {
			for(int i=0; i<n;i++) {
				if(arr[i] == array[j]) {
					answer[i] = rank;
					cnt++;
				}
			}
			rank+= cnt;
			cnt = 0;
		}*/
		
		return answer;
	}
	public static void main(String[] args){
		Main02_08 T = new Main02_08();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		for(int x :T.solution(n, arr)) System.out.print(x+" ");
	}
}