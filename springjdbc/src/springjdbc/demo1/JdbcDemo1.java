package springjdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBCģ���ʹ��
 * @author Administrator
 *
 */
public class JdbcDemo1 {
	@Test
	//jdbc��ʹ��������dbutils
	public void demo1() {
		//�������ӳ�
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("lu910208");
		//����jdbcģ��
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into acoount values (null,?,?)", "winston",10000d);
	}
}
