package algorithm07;

import java.util.*;

class BFS송아지찾기상태트리 {
	int answer=0;
	int[] dis={1, -1, 5};
	int[] ch;
	
	Queue<Integer> Q = new LinkedList<>();
	public int BFS2(int s, int e){
		ch = new int[10001];
		int L = 0;
		Q.add(s);
		ch[s]=1;
		while(!Q.isEmpty()) {
			int length = Q.size();
			for (int i = 0; i < length; i++) {
				int v = Q.poll();
				for(int move : dis) {
					int nextV = v+ move;
					if(nextV == e) return L+1;
					if(0<nextV && nextV <=10000 &&ch[nextV]==0) {
						ch[nextV] =1;
						Q.add(nextV);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
	public int BFS(int s, int e){
		ch=new int[10001];
		ch[s]=1;
		Q.offer(s);
		int L=0;
		while(!Q.isEmpty()){
			int len=Q.size();
			for(int i=0; i<len; i++){
				int x = Q.poll();
				for(int j=0; j<3; j++){
					int nx=x+dis[j];
					if(nx==e){
						return L+1;
					}
					if(nx>=1 && nx<=10000 && ch[nx]==0){
						ch[nx]=1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}

	public static void main(String[] args){
		BFS송아지찾기상태트리 T = new BFS송아지찾기상태트리();
		int start = 5; // 시작 위치
		int end = 14;  // 목적지 위치
		System.out.println(T.BFS2(start, end));
	}	
}