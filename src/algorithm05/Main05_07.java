package algorithm05;
import java.util.*;
//교육과정설계
class Main05_07 {	
	public String solution(String need, String plan){
		String answer="YES";
		Queue<Character> nQ = new LinkedList<Character>();
		for(char c : plan.toCharArray()) nQ.offer(c);
		for(char c : need.toCharArray()) {
			//포함되어있나?
			if(!nQ.contains(c)){
				return "NO";
			}else {
				//포함된 것이 나올 때까지 제거한다.
				//이 과정에서 need에 다음 요소 중 하나가 제거된다면
				//, 순서가 지켜지지 않은 것이다.
				while(nQ.poll()!=c) {
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args){
		Main05_07 T = new Main05_07();
		Scanner kb = new Scanner(System.in);
		String a=kb.next();
		String b=kb.next();
		System.out.println(T.solution(a, b));
	}
}