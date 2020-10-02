package kr.co.eduhansol.sms.sample.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.eduhansol.sms.sample.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	/** 게시글 목록 조회 테스트 */
	@Test
	public void testGetBoardList() { 
		
		try {
			
			List<BoardVO> boardList = boardMapper.getBoardList();
			
			log.info(boardList);
			
			// 게시글 1건일 경우 테스트 통과
			assertEquals(1, boardList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 상세 조회 테스트 */
	@Test
	public void testGetBoardDetail() { 

		try {
			
			BoardVO boardDetail = boardMapper.getBoardDetail(2);
			 
			log.info(boardDetail);
			
			// 게시글 상세 조회 정보가 있으면 테스트 통과
			assertNotNull(boardDetail);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 등록 테스트 */
	@Test
	public void testInsertBoard() { 

		try {

			BoardVO boardVO = new BoardVO();
			boardVO.setBoard_writer("게시글 작성자");
			boardVO.setBoard_subject("게시글 제목_1");
			boardVO.setBoard_content("게시글 제목_1");
			
			boardMapper.insertBoard(boardVO);

			List<BoardVO> boardList = boardMapper.getBoardList();
			
			log.info(boardList);
			
			// 게시글 2건일 경우 경우 테스트 통과
			assertEquals(2, boardList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 수정 테스트 */
	@Test
	public void testUpdateBoard() {

		try {

			BoardVO boardVO = new BoardVO();
			boardVO.setBoard_seq(1);
			boardVO.setBoard_subject("게시글 제목_0");
			boardVO.setBoard_content("게시글 제목_0");
			
			boardMapper.updateBoard(boardVO);

			BoardVO boardDetail = boardMapper.getBoardDetail(1);
			
			log.info(boardDetail);
			
			// 게시글 제목이 수정된 경우 테스트 통과
			assertEquals("게시글 제목_0", boardDetail.getBoard_subject());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 게시글 삭제 테스트 */
	@Test
	public void testDeleteBoard() {
		
		try {
			
			boardMapper.deleteBoard(6);

			BoardVO boardDetail = boardMapper.getBoardDetail(6);
			
			log.info(boardDetail);
			
			// 삭제한 게시글이 조회되지 않으면 테스트 통과
			assertNull(boardDetail);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}