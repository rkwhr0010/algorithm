package algorithm05;

import java.util.*;
//카카오 크레인 인형뽑기
class Main05_03 {	
	Stack<Integer> stack = new Stack<>();
	int count = 0;
	int move = 0;
	int[][] board;
	int[] moves;
	
	public int solution(int[][] board, int[] moves){
		this.board = board;
		this.moves = moves;
        
		for(int col=0;col<moves.length;col++) {
			get(moves[col]-1);//-1 배열 보정
		}
		return count;
	}
	
	public void get(int col) {
		for (int row = 0; row< board[col].length ; row++) {
			int doll = board[row][col]; 
			if(doll != 0) { // 0이 아니면 인형뽑기 
				board[row][col] = 0; //뽑은 인형자리에 0 대입
				push(doll);
				return;
			}
		}
	}
	
	public boolean push(Integer num) {
		//맨 위 값과 뽑은 인형이 같으면 터트림
		if(!stack.isEmpty() && stack.peek().equals(num)) {
			stack.pop();
			count += 2;
			return false;
		}else {
			stack.add(num);
			return true;
		}
	}

	public static void main(String[] args){
		Main05_03 T = new Main05_03();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] board=new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				board[i][j]=kb.nextInt();
			}
		}
		int m=kb.nextInt();
		int[] moves=new int[m];
		for(int i=0; i<m; i++) moves[i]=kb.nextInt();
		System.out.println(T.solution(board, moves));
	}
}

