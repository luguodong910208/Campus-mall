package practise2;

public class FatherClass {
	private String name;
	FatherClass(){
		System.out.println("--������޲ι�����--");
	}
	FatherClass(String name){
		this.name = name;
		System.out.println("--������вι�����--"+this.name);
	}
	static {
		System.out.println("--����ľ�̬�����");
	}
	{
		System.out.println("--����ķǾ�̬�����--");
	}
	public void speak() {
		System.out.println("--����ķ���--");
	}
	public static void main(String[] args) {
		System.out.println("--����������--");
		FatherClass father = new FatherClass("���׵�����");
		father.speak();
	}
}

