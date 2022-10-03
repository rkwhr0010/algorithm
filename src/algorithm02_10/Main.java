package algorithm02_10;

import java.util.*;
import java.util.stream.IntStream;
class Main {	

	private static boolean isTop(int[][]arr, int i, int j) {
		
		return arr[i][j] < arr[i - 1][j] ? false
		     : arr[i][j] < arr[i + 1][j] ? false
		     : arr[i][j] < arr[i][j - 1] ? false 
		     : arr[i][j] < arr[i][j + 1] ? false : true;
	}
	
	
	public static void main(String[] args){
		final int SIZE = 10;
		final int MAX = 20;
		int[] array = IntStream.range(0, SIZE)
		         .toArray();
		int[][] arr = Arrays.stream(array)
              .mapToObj(n->{
            	  return new Random().ints(SIZE, 0, MAX)
            			             .toArray();
              }).toArray(int[][]::new);
		
		
		
		
	}
}