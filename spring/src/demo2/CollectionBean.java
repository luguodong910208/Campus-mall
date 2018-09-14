package demo2;

import java.util.Arrays;

/**
 * 属性集合的注入
 * @author Administrator
 *
 */
public class CollectionBean {
	private String[] arrs;

	public void setArrs(String[] arrs) {
		this.arrs = arrs;
	}

	@Override
	public String toString() {
		return "CollectionBean [arrs=" + Arrays.toString(arrs) + "]";
	}
	
}
