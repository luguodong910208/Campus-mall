package demo1;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void save() {
		System.out.println("保存商品");
	}

	@Override
	public void update() {
		System.out.println("更新商品");
	}

	@Override
	public void find() {
		System.out.println("找寻商品");
		int i=1/0;
	}

	@Override
	public String delete() {
		System.out.println("删除商品");
		return "winston";
	}

}
