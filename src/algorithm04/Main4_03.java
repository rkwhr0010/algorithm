package algorithm04;


import java.util.*;

//해쉬맵 , key 중복X, value 중복가능,
//해쉬셋을 사용하려 했는데, 타임아웃...
//해쉬맵을 이렇게도 응용가능하다.. 투포인터를 이용한 슬라이딩
//해쉬맵 key를 해쉬셋처럼 사용하되 value로 key의 상태값을 표시하는 것
class Main4_03 {	
	public List<Integer> solution(int n, int k, int[] arr){
		List<Integer> answer = new ArrayList<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<k;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		answer.add(map.size());
		for(int rt=k,lt=0;rt<arr.length;rt++) {
			Integer tmp = map.getOrDefault(arr[lt], 0);
			if(1< tmp ) {
				map.put(arr[lt], tmp-1);
			}else {
				map.remove(arr[lt]);
			}
			lt++;
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			answer.add(map.size());
		}
		
		
		return answer;
	}

	public static void main(String[] args){
		Main4_03 T = new Main4_03();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int k=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		for(int x : T.solution(n, k, arr)) System.out.print(x+" ");
	}
}