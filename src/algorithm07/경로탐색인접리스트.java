package algorithm07;

import java.util.*;

class 경로탐색인접리스트 {
	static int n, m, answer=0;
	static List<List<Integer>> graph = new ArrayList<List<Integer>>();
	static int[] ch;
	static Stack<Integer> s = new Stack<Integer>();
	
	public void DFS2(int v){
		if(v == n) {
			System.out.println(s);
			answer++;
		} else {
			for(Integer nx : graph.get(v)) {
				if(ch[nx]==0) {//첫방문
					ch[nx] = 1;//이제 방문함
					s.push(nx);//로그용
					DFS2(nx);
					s.pop();
					ch[nx] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		경로탐색인접리스트 T = new 경로탐색인접리스트();
		n=5; // 목표 목적지 노드
		ch=new int[n+1];
		// aArr와 bArr를 조합
		// 1->2  , 1->3  , 1->4 이렇게 내가 갈 경로 배열
		int[] aArr= {1,1,1,2,2,2,3,4,4};
		int[] bArr= {2,3,4,1,3,5,4,2,5};
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<bArr.length; i++){
			int a= aArr[i];
			int b= bArr[i];
			graph.get(a).add(b);
		}
		ch[1]=1;
		s.push(1);
		T.DFS2(1);
		System.out.println(answer);
	}	
}