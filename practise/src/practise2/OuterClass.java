package practise2;

public class OuterClass {
	private class InterClass{
		public InterClass() {
			System.out.println("InterClass Create");
		}
	};
	
	public OuterClass() {
		InterClass ic = new InterClass();
		System.out.println("OuterClass Create");
	}
	
	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
	}
}
