package practise2;

public class FatherClass {
	private String name;
	FatherClass(){
		System.out.println("--父类的无参构造器--");
	}
	FatherClass(String name){
		this.name = name;
		System.out.println("--父类的有参构造器--"+this.name);
	}
	static {
		System.out.println("--父类的静态代码块");
	}
	{
		System.out.println("--父类的非静态代码块--");
	}
	public void speak() {
		System.out.println("--父类的方法--");
	}
	public static void main(String[] args) {
		System.out.println("--父类主程序--");
		FatherClass father = new FatherClass("父亲的名字");
		father.speak();
	}
}

