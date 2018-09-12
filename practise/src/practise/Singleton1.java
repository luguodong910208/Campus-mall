package practise;

public class Singleton1 {
	private Singleton1() {};
	private static Singleton1 instance = new Singleton1();
	//提供供外部访问本class的静态方法，可以直接访问
	public static Singleton1 getInstance() {
		return instance;
	}		
}
