package algorithm08;


class 조합의경우수$메모이제이션{
	static int[][] dy=new int[35][35];
	static int cnt1,cnt2;
	
	static int DFS1(int n, int r){
		cnt1++;
		if(n==r || r==0) return 1;
		else return DFS1(n-1, r-1)+DFS1(n-1, r);
	}
	
	static int DFS2(int n, int r){
		cnt2++;
		if(dy[n][r]!=0) return dy[n][r];
		if(n==r||r==0) return 1;
		else {
			return dy[n][r]=DFS2(n-1,r-1)+DFS2(n-1,r);
		}
		
	}
	
	public static void main(String[] args){
		int n=30;
		int r=20;
		
		System.out.print("메모이제이션 사용 안함 ");
		System.out.println(DFS1(n, r)+" "+cnt1);
		System.out.print("메모이제이션 사용 함 ");
		System.out.println(DFS2(n, r)+" "+cnt2);
	}
}