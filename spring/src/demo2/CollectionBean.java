package demo2;

import java.util.Arrays;

/**
 * ���Լ��ϵ�ע��
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
