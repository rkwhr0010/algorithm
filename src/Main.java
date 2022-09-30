
public class Main {
	public static void main(String[] args) {
		String a = "8sfgua98gyua89ga89ywerg98awerg";
		
		for(int i=0 ;i<3;i++) {
			System.out.println(a.substring(0, 7));
			
			a = a.substring(7);
			System.out.println(a);
			
		}
		
		
	}
}
