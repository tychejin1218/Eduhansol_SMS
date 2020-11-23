package kr.co.eduhansol.sms.sample.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

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
public class SampleMapperOracleTest {

	@Setter(onMethod_ = @Autowired)
	private SampleMapperOracle sampleMapperOracle;

	@Test
	public void testGetBoardList() { // 게시글 목록 조회 테스트
		try {

			List<Map<String, String>> boardList = sampleMapperOracle.getSampleList();

			log.info(boardList);

			// 게시글 5건일 경우 테스트 통과
			assertEquals(5, boardList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}