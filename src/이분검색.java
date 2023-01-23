import java.util.*;
class 이분검색 {
	public static void binarySearch(){
		final int SIZE = 1_000; // 사이즈를 가차없이 100배씩 늘려보면, 이분검색의 진가를 알 수 있다.
		long startTime = 0L;
		
		int[] arr = new Random().ints(1,Integer.MAX_VALUE)
			.distinct()
			.limit(SIZE)
			.sorted()  //이분 검색은 반드시 정렬이 필요하다.
			.toArray();
		int target = arr[new Random().nextInt(SIZE-1)];
		startTime = System.nanoTime();
		int key = Arrays.binarySearch(arr, target);
		System.out.println("라이브러리 사용 - key: "+key+", value:"+arr[key]);
		System.out.println("소요시간 : "+(System.nanoTime()-startTime)+"나노초");
		
		int lt = 0;
		int rt = arr.length-1;
		int count = 0;
		
		System.out.println("찾아보자!! - " + target);
		
		startTime = System.nanoTime();
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			count ++;
			System.out.println("lt:"+lt+", rt:"+rt+", mid:"+mid+", arr[mid]:"+arr[mid]);
			if(target == arr[mid]) {
				System.out.println("목표숫자 : "+target+", "+count+"번 만에 찾음!!!");
				System.out.println("소요시간 : "+(System.nanoTime()-startTime)+"나노초");
				break;
			}else if(target < arr[mid]) {
				rt = mid -1;
			}else {
				lt = mid +1;
			}
		}
	}
	
	public static void main(String[] args){
		binarySearch();
	}
}