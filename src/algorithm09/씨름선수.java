package algorithm09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/* 입력
5
172 67
183 65
180 70
170 72
181 60
*/
public class 씨름선수 {
	public static void main(String[] args) {
		씨름선수 T = new 씨름선수();
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> list = new ArrayList<씨름선수.Person>();
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			list.add( T.new Person( sc.nextInt(), sc.nextInt() ) );
		}
		Collections.sort(list,Comparator.reverseOrder());
		System.out.println(list);
		System.out.println(T.solution(list));
		
		sc.close();
	}
	
	private int solution(ArrayList<Person> list) {
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		
		for (Person person : list) {
			if(max<person.weight) {
				cnt++;
				max = person.weight;
			}
		}
		return cnt;
	}

	class Person implements Comparable<Person>{
		int height;
		int weight;
		public Person(int height, int weight) {
			super();
			this.height = height;
			this.weight = weight;
		}
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.height, o.height);
		}
		@Override
		public String toString() {
			return height+" "+weight;
		}
	}
	
}
