package tx.demo1;

public class AccountServiceImpl implements AccountService {
	//×¢ÈëDao
	private AccountDao accountDao;
	
	@Override
	public void transfer(String from, String to, Double money) {
		accountDao.outMoney(from, money);
		accountDao.inMoney(to, money);
	}
}
