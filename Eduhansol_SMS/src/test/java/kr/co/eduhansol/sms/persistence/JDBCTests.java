package kr.co.eduhansol.sms.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {	
	
	private static final String DRIVER   = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL 	 = "jdbc:sqlserver://202.89.125.167:1433;DatabaseName=HSSMSDB;SelectMethod=cursor";
	private static final String USER 	 = "hssmsuser";
	private static final String PASSWORD = "hssmsuser#18";
	
	/*private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
	private static final String URL 	 = "jdbc:mysql://localhost:3306/board?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String USER 	 = "board";
	private static final String PASSWORD = "password1!";*/

	/*private static final String DRIVER   = "oracle.jdbc.driver.OracleDriver";
	private static final String URL 	 = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER 	 = "board";
	private static final String PASSWORD = "password";*/
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
