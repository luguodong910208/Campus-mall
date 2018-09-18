package tx.demo1;
/**
 * 转账业务的接口
 * @author Administrator
 *
 */
public interface AccountService {
	public void transfer(String from,String to, Double money);
}
