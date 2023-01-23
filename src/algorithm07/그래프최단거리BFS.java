package algorithm07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//각정점으로 가는 최소 이동 간선수
class 그래프최단거리BFS {
	static int n, m, answer=0;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] ch, dis;
	
	public void BFS2(int v){
		LinkedList<Integer> q = new LinkedList<Integer>();
		ch[v] = 1;
		dis[v] = 0;
		
		q.offer(v);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(Integer next : graph.get(cur)) {
				if(ch[next] == 0) {
					ch[next] = 1;
					dis[next] = dis[cur]+1;
					q.add(next);
				}
			}
		}
	}
	
	public void BFS(int v){
		ch[v]=1;
		dis[v]=0;
		Queue<Integer> queue=new LinkedList<>();
		queue.offer(v);
		while(!queue.isEmpty()){
			int cv=queue.poll();
			for(int nv : graph.get(cv)){
				if(ch[nv]==0){
					ch[nv]=1;
					queue.offer(nv);
					dis[nv]=dis[cv]+1;
				}
			}
		}
	}
	
	public static void main(String[] args){
		그래프최단거리BFS T = new 그래프최단거리BFS();
		n=6;
		ch=new int[n+1];
		dis=new int[n+1];
		int[] aArr= {1,1,2,2,3,4,4,6,6};
		int[] bArr= {3,4,1,5,4,5,6,2,5};
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<bArr.length; i++){
			int a= aArr[i];
			int b= bArr[i];
			graph.get(a).add(b);
		}
		T.BFS2(1);
		for(int i=2; i<=n; i++){
			System.out.println(i+" : "+dis[i]);
		}
	}	
}