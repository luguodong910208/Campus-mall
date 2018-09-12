package practise2;

public class ChildClass extends FatherClass {
	private String name;
	static {
		System.out.println("子类的静态代码块");
	}
	{
		System.out.println("子类的非静态代码块");
	}
	public ChildClass() {
		System.out.println("子类无参构造函数");
	}
	ChildClass(String name){
		this.name = name;
		System.out.println("子类的有参构造函数"+this.name);
	}
	@Override
	public void speak() {
		System.out.println("子类重写了父类的方法");
	}
	public static void main(String[] args) {
		System.out.println("子类主程序");
		FatherClass father = new FatherClass("父类的名字");
		father.speak();
		ChildClass child = new ChildClass();
		child.speak();
	}
}
