package practise2;

public class ChildClass extends FatherClass {
	private String name;
	static {
		System.out.println("����ľ�̬�����");
	}
	{
		System.out.println("����ķǾ�̬�����");
	}
	public ChildClass() {
		System.out.println("�����޲ι��캯��");
	}
	ChildClass(String name){
		this.name = name;
		System.out.println("������вι��캯��"+this.name);
	}
	@Override
	public void speak() {
		System.out.println("������д�˸���ķ���");
	}
	public static void main(String[] args) {
		System.out.println("����������");
		FatherClass father = new FatherClass("���������");
		father.speak();
		ChildClass child = new ChildClass();
		child.speak();
	}
}
