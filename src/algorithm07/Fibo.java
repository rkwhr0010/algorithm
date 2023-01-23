package algorithm07;

import java.util.Arrays;

public class Fibo {
	
	static long forFibo(int n) {
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			if(i<2) arr[i]=1;
			else arr[i]= arr[i-2]+arr[i-1];
		}
		return arr[n-1];
	}
	
	static long recurFibo(int n) {
		if(n<=2) return 1;
		else {
			return recurFibo(n-2)+recurFibo(n-1);
		}
	}
	
	static long[] arr;
	
	static long recurFibo2(int n) {
		if(arr[n]!=0) return arr[n];
		if(n<=2) {
			return arr[n] = 1;
		} else {
			return arr[n]=recurFibo2(n-2)+recurFibo2(n-1);
		}
	}
	
	public static void main(String[] args) {
		int n = 45;
		arr = new long[n+1];
		time(()->System.out.println("##"+forFibo(n)));
		time(()->System.out.println("##"+recurFibo(n)));
		time(()->System.out.println("##"+recurFibo2(n)));
	}
	
	static void time(Runnable run) {
		long s = System.nanoTime();
		run.run();
		System.out.println(System.nanoTime()-s);
	}
}
