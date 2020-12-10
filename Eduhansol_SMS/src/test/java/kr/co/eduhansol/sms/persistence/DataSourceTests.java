package kr.co.eduhansol.sms.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSourceMssql;
	
	/*@Setter(onMethod_ = { @Autowired })
	private DataSource dataSourceMysql;

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSourceOracle;*/
	
	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactoryMssql;
	
	/*@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactoryMysql;
	
	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactoryOracle;*/
	
	@Test
	public void testConnectionMssql() {

		try (Connection con = dataSourceMssql.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/*@Test
	public void testConnectionMysql() {

		try (Connection con = dataSourceMysql.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConnectionOracle() {

		try (Connection con = dataSourceOracle.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}*/
	
	@Test
	public void testMyBatisMssql() {

		try (SqlSession session = sqlSessionFactoryMssql.openSession(); Connection con = session.getConnection();) {
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	/*@Test
	public void testMyBatisMysql() {

		try (SqlSession session = sqlSessionFactoryMysql.openSession(); Connection con = session.getConnection();) {
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testMyBatisOracle() {

		try (SqlSession session = sqlSessionFactoryOracle.openSession(); Connection con = session.getConnection();) {
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}*/
}
