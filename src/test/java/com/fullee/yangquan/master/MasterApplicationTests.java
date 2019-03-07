package com.fullee.yangquan.master;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterApplicationTests {

	@Autowired
	private HikariDataSource dataSource;

	@Test
	public void contextLoads() throws SQLException {

		Connection connection = dataSource.getConnection();

		PreparedStatement statement = connection.prepareStatement("show columns from system_user");
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			String string = resultSet.getString(1);
			String x = resultSet.getString(2);
			System.out.println(string+"-"+x);
		}

		System.out.println("完成");
	}
}
