package algorithm05;

import java.io.IOException;
import java.util.*;

//응급실
class Main05_08 {	
	public int solution(int n, int m, int[] arr){
		Queue<Person> queue = new LinkedList<>();
		for(int i=0;i<n;i++) {
			queue.offer(new Person(i, arr[i]));
		}
		int answer = 0;
		
		while(!queue.isEmpty()) {
			Person ps = queue.poll();
			
			
			boolean flag = false;
			for(Person p : queue ) {
				if(ps.getPriority() < p.getPriority()) {
					flag = true;
					break;
				}
			}
			if(flag) {
				queue.offer(ps);
			}else {
				answer++;
				if(ps.getOrder()==m) {
					return answer;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{
		Main05_08 T = new Main05_08();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int m=kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		System.out.println(T.solution(n, m, arr));	
	}
	class Person{
		int order;
		int priority;
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		public Person(int order, int priority) {
			super();
			this.order = order;
			this.priority = priority;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + order;
			result = prime * result + priority;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (order != other.order)
				return false;
			if (priority != other.priority)
				return false;
			return true;
		}
		private Main05_08 getEnclosingInstance() {
			return Main05_08.this;
		}
		@Override
		public String toString() {
			return order+":"+priority;
		}
	}
}