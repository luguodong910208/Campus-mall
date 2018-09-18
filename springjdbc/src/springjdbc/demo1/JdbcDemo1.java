package springjdbc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBC模板的使用
 * @author Administrator
 *
 */
public class JdbcDemo1 {
	@Test
	//jdbc的使用类似于dbutils
	public void demo1() {
		//创建连接池
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("lu910208");
		//创建jdbc模板
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into acoount values (null,?,?)", "winston",10000d);
	}
}
