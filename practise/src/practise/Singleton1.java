package practise;

public class Singleton1 {
	private Singleton1() {};
	private static Singleton1 instance = new Singleton1();
	//�ṩ���ⲿ���ʱ�class�ľ�̬����������ֱ�ӷ���
	public static Singleton1 getInstance() {
		return instance;
	}		
}
