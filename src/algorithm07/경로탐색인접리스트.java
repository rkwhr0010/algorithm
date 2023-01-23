package algorithm07;

import java.util.*;


//n 노드 개수
//5번까지가는 모든 경로 수
class 경로탐색인접리스트 {
	static int n, m, answer=0;
	static List<List<Integer>> graph = new ArrayList<List<Integer>>();
	static int[] ch;
	static StringBuilder sb = new StringBuilder();
	static int order=1;
	
	public void DFS2(int v){
		if(v == n) {
			answer++;
		} else {
			for(Integer nx : graph.get(v)) {
				if(ch[nx]==0) {
					ch[nx] = 1;
					DFS2(nx);
					ch[nx] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		경로탐색인접리스트 T = new 경로탐색인접리스트();
		n=5;
		ch=new int[n+1];
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
		T.DFS2(1);
		System.out.println(answer);
	}	
}